package com.notgabs.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		Collection<UserDetails> users = new ArrayList<>();

		users.add(User.builder().username("john").password("{noop}test").roles("EMPLOYEE").build());
		users.add(User.builder().username("mary").password("{noop}test").roles("MANAGER").build());
		users.add(User.builder().username("gabs").password("{noop}test").roles("ADMIN").build());

		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// AUTHENTICATION IS REQUIRED FOR ACCESSING THE APP
		
		return http.authorizeRequests(configurer -> configurer
                .antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated())

				// OVERRIDES THE DEFAULT SPRING LOGIN PAGE
				.formLogin(configurer -> configurer.loginPage("/login")
						.loginProcessingUrl("/authenticate").permitAll())

				.build();
	}
}