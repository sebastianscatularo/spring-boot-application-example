package org.informatorio.spring.security.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sebastian Scatulao
 */
public interface TokenRepository extends JpaRepository<Token, String> {
}
