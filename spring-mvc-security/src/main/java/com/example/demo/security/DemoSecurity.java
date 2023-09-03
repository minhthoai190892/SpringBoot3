package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurity {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(configurer->configurer
														.requestMatchers("/","/home").permitAll()
														.requestMatchers("/admin/**").hasRole("ADMIN")
														.requestMatchers("/leaders/**").hasRole("MANAGER")
				)
		.formLogin(login->login.loginPage("/showMyLoginPage")
							 	.loginProcessingUrl("/authenticateTheuser")
							 	.permitAll())
		.logout(logout->logout.permitAll())
		
		.rememberMe(me -> me//kích hoạt nhớ tài khoản
                //tạo một key mặc định cho ứng dụng trong cookie
                .key("bWluaHRob2FpJTQwZ21haWxxd2UuY29tOjE2ODc0OTQ0NzEwNTA6U0hBMjU2OjdiNTk5NTliOTU1MDUxOTgwOTJjMzFhYzMwMGIyNDc0MTA5ZjQ0YWE5YmJlZmE0ZWExZDIyZDRjOWYyMjlkMjA")
                .tokenValiditySeconds(7 * 24 * 60 * 60))//thây đổi thời gian hết hạn của key 
		
		;
		
		return httpSecurity.build();
	}
}
