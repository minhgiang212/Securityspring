package com.example.Security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    MyFilter myFilter;
    @Bean
    SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http.cors().disable().csrf().disable();
        http.authorizeRequests().requestMatchers("/Users/login").permitAll();
        http.authorizeRequests().requestMatchers("/Users/**").hasRole("admin");



        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) ;
        http.addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class);
        System.out.println(" ==== Config security ok =======");
        return http.build();

    }

}
