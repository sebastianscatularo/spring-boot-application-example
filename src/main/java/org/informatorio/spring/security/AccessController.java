package org.informatorio.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author Sebastian Scatularo
 */
@Controller
public class AccessController {

    @RequestMapping("/access")
    public String accessView() {
        return "login";
    }
}
