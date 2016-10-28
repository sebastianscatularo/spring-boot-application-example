package org.informatorio.spring.security.users;

/**
 * @author Sebastian Scatularo
 */
public interface MailService {
    void sendActivationMail(String username, String mail);
}
