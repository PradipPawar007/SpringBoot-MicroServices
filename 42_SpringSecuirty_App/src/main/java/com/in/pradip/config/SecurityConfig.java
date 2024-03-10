package com.in.pradip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
   public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		System.out.println("Filter Called....");
        http.authorizeHttpRequests(
                (req) -> req.requestMatchers("/contact", "/logincheck")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        ).formLogin();
		return http.build();
	}
}
