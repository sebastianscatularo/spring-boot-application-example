package org.informatorio.spring.security.users;

import lombok.Data;

/**
 * @author Sebastian Scatularo
 */
@Data
public class Status {
    private final String message;

    private Status(String message) {
        this.message = message;
    }

    public static Status of(String s) {
        return new Status(s);
    }
}
