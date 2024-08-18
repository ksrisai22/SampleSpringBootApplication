package com.example.spring_boot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
public class SecurityConfigurtion  {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user  = User.withUsername("user")
				                .password(encoder.encode("userpass"))
				                .roles("USER")
				                .build();
		UserDetails admin = User.withUsername("admin")
								.password(encoder.encode("adminpass"))
								.roles("ADMIN")
								.build();
	    return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeHttpRequests ->
        authorizeHttpRequests
        .requestMatchers("/welcome").hasAnyRole("USER","ADMIN")
        .requestMatchers("/admin").hasRole("ADMIN").requestMatchers("/**").permitAll()).formLogin();
		return http.build();
	}

}
