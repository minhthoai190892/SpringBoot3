package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.Membership;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountService accountService,Membership membership) {
		return runner->{
			demoTheBeforeAdvice(accountService,membership);
		};
	}
	private void demoTheBeforeAdvice(AccountService accountService,Membership membership) {
		Account account = new Account();
		accountService.addAccount(account,true);

		membership.addSillyMember();
	}

}
