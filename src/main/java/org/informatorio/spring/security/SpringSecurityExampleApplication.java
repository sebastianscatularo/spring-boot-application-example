package org.informatorio.spring.security;

import org.informatorio.spring.security.users.User;
import org.informatorio.spring.security.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityExampleApplication implements CommandLineRunner {
	private final UserRepository userRepository;

	public SpringSecurityExampleApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setPassword("abc123");
		user.setUsername("sebastian@informatorio.com");
		userRepository.save(user);
	}
}
