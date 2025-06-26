package com.spms.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class that sets up web security for the application.
 * This class is responsible for configuring authentication and authorization rules,
 * as well as setting up password encoding.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    /**
     * Configures and provides a BCrypt password encoder bean.
     * This is used for securely hashing and verifying user passwords.
     *
     * @return BCryptPasswordEncoder instance for password encoding and verification
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Configures the security filter chain that defines request-level security.
     * Currently configured to:
     * - Disable CSRF protection (for API endpoints, typically enabled for web apps with sessions)
     - Permit all requests without authentication (temporary configuration)
     *
     * @param http the HttpSecurity to configure
     * @return SecurityFilterChain with the configured security rules
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for stateless API
            .authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()  // Allow all requests without authentication
            );
        
        return http.build();
    }
}