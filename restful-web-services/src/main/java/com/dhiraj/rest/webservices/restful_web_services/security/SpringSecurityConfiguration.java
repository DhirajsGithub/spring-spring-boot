package com.dhiraj.rest.webservices.restful_web_services.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 1) Allow POST and PUT requests without authentication
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/**").permitAll() // Allows all requests to be accessed without authentication
		);

		// 2) Apply basic authentication for all other requests (excluding POST and PUT)
		http.httpBasic(withDefaults());

		// 3) Disable CSRF for testing (not recommended in production for most cases)
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
