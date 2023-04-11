package com.assignment.clothes.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.assignment.clothes.model.form.User;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(com.assignment.clothes.repository.UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException(username);
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests()
                .requestMatchers(toH2Console()).permitAll()
                .requestMatchers("/design").hasRole("ROLE_ADMIN")
                .requestMatchers("/design").hasRole("ROLE_WAREHOuSE")
                .requestMatchers("delete-item").hasRole("ROLE_ADMIN")
                .requestMatchers("/clothesList").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true))
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console()))
                .headers(headers -> headers
                        .frameOptions()
                        .sameOrigin())
                .build();
    }
}