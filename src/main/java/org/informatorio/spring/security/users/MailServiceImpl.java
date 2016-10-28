package org.informatorio.spring.security.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Sebastian Scatularo
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {
    @Override
    public void sendActivationMail(String username, String mail) {
        log.info("Token {} - Mail {}", username, mail);
    }
}
