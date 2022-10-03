package com.notgabs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	@Autowired
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		Collection<UserDetails> users = new ArrayList<>();
//
//		users.add(User.builder().username("john").password("{noop}test").roles("EMPLOYEE").build());
//		users.add(User.builder().username("mary").password("{noop}test").roles("MANAGER").build());
//		users.add(User.builder().username("gabs").password("{noop}test").roles("ADMIN").build());
//
//		return new InMemoryUserDetailsManager(users);
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// AUTHENTICATION IS REQUIRED FOR ACCESSING THE APP

		return http
				.authorizeRequests(configurer -> configurer.antMatchers("/resources/**").permitAll()
						.antMatchers("/admin").hasRole("ADMIN").antMatchers("/manager").hasRole("MANAGER").anyRequest()
						.authenticated())
				// OVERRIDES THE DEFAULT SPRING LOGIN PAGE
				.formLogin(configurer -> configurer.loginPage("/login").loginProcessingUrl("/authenticate").permitAll())
				.logout(LogoutConfigurer::permitAll).exceptionHandling().accessDeniedPage("/error").and().build();
	}
}