package org.informatorio.spring.security.users;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Sebastian Scatularo
 */
@Data
@Entity
public class Token {
    @Id
    private String token;
    @Column
    private Integer userId;
}
