package com.in.pradip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.in.pradip.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecuirtyConfig {

	/**
	 * The below code is for testing purpose only we can not use in developement
	 * 
	 * @Bean public InMemoryUserDetailsManager configure() { UserDetails adminUser =
	 * User.withDefaultPasswordEncoder() .username("pradip").password("Pradip@123")
	 * .authorities("ADMIN").build(); UserDetails normalUser =
	 * User.withDefaultPasswordEncoder() .username("raja").password("Raja@123")
	 * .authorities("USER") .build(); return new
	 * InMemoryUserDetailsManager(adminUser,normalUser); }
	 */
	
	@Autowired
	private MyUserDetailsService userDtlsService;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDtlsService)
			   .passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	 
	
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		      
		http.authorizeHttpRequests((req) ->
		        req.requestMatchers("/contact")
		           .permitAll()
                   .anyRequest().authenticated()
				).formLogin();
		return http.build();
	}
}
