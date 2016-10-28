package org.informatorio.spring.security.users;

import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

/**
 * @author Sebastian Scatularo
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    private final MailService mailService;
    private final TokenRepository tokenRepository;

    public UserController(UserRepository userRepository,
                          TokenRepository tokenRepository,
                          MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
        this.tokenRepository = tokenRepository;
    }

    @PostMapping
    public ResponseEntity<Status> users(@RequestBody User user) {
        if (userRepository.exists(Example.of(user))) {
            return ResponseEntity.ok(Status.of("User Exist"));
        } else {
            String tokenString = UUID.randomUUID().toString();
            user = userRepository.save(user);
            Token token = new Token();
            token.setToken(tokenString);
            token.setUserId(user.getId());
            tokenRepository.save(token);
            mailService.sendActivationMail(user.getUsername(), tokenString);
            return ResponseEntity.ok(Status.of("User Created"));
        }
    }

    @GetMapping("/current")
    public ResponseEntity<Principal> currentUser(Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/activate/{token}")
    public ResponseEntity<Status> activate(@PathVariable("token") String tokenString) {
        Token token = tokenRepository.findOne(tokenString);
        User user = userRepository.findOne(token.getUserId());
        user.setStatus(true);
        userRepository.save(user);
        tokenRepository.delete(tokenString);
        return ResponseEntity.ok(Status.of("User activated"));
    }
}
