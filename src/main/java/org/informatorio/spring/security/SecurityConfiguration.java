package org.informatorio.spring.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

/**
 * @author Sebastian Scatularo
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/activate/*").permitAll()
                .antMatchers("/app/**/*.js","/app/views/*.html", "/", "/index.html")
                .permitAll()
                .antMatchers("/api/**")
                .authenticated()
        .and()
                .httpBasic()
        .and()
                .formLogin()
                .loginPage("/access")
                .defaultSuccessUrl("/")
                .permitAll()
        .and()
                .logout()
        .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
