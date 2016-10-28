package org.informatorio.spring.security.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sebsatian Scatularo
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}