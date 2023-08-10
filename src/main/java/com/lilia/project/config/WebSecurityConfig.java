package com.lilia.project.config;

import com.lilia.project.service.UserService;
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, UserService userService) throws Exception {
        http
                .csrf()
                .disable() // disable Cross Site Request Forgery (it requires additional configuration if not disabled)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/", "/home", "/index", "/css/**", "/js/**").permitAll() // allow static data without auth
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll() // allow forward and error dispatching without auth
                        .requestMatchers("/students/**").hasAnyRole("ADMIN", "TEACHER") // request-based authorization, allow requests for specific authorities only
                        .requestMatchers("/courses/add").hasAnyRole("ADMIN")
                        .requestMatchers("/courses/*").hasAnyRole("ADMIN")
                        .requestMatchers("/course/edit").hasRole("ADMIN")
                        .anyRequest().authenticated() // all other requests (not from the list above) must be authenticated
                )
                .sessionManagement(Customizer.withDefaults())
                .userDetailsService(userService)
                .passwordManagement(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()) // basic authentication means logging in using username & password combination
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
