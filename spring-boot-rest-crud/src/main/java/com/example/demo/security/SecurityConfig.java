package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	//hàm tìm nạp user trong database
	@Bean
	public UserDetailsManager detailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(configurer->configurer
												.requestMatchers(HttpMethod.GET,"/students").hasRole("EMPLOYEE")
												.requestMatchers(HttpMethod.GET,"/students/**").hasRole("EMPLOYEE")
												.requestMatchers(HttpMethod.POST,"/students").hasRole("MANAGER")
												.requestMatchers(HttpMethod.PUT,"/students").hasRole("MANAGER")
												.requestMatchers(HttpMethod.DELETE,"/students/**").hasRole("ADMIN")
												.requestMatchers("/test/**").permitAll()
				);
		
		httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.csrf(csrf->csrf.disable());
		return httpSecurity.build();
		
	}
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails john = User.builder()
//									.username("john")
//									.password("{noop}test")
//									.roles("EMPLOYEE")
//									.build();
//		UserDetails mary = User.builder()
//									.username("mary")
//									.password("{noop}test")
//									.roles("EMPLOYEE","MANAGER")
//									.build();
//		UserDetails susan = User.builder()
//									.username("susan")
//									.password("{noop}test")
//									.roles("EMPLOYEE","MANAGER","ADMIN")
//									.build();
//		UserDetails thoai = User.builder()
//									.username("thoai")
//									.password("{noop}test")
//									.roles("MANAGER")
//									.build();
//		return new InMemoryUserDetailsManager(john,mary,susan,thoai);
//	}
//	
}
