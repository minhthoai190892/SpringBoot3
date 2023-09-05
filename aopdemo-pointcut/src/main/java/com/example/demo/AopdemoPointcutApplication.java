package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.MemberService;

@SpringBootApplication
public class AopdemoPointcutApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoPointcutApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountService accountService,MemberService memberService) {
		return runner ->{
			demoTheBeforeAdvice(accountService,memberService);
		};
	}
	private void demoTheBeforeAdvice(AccountService accountService, MemberService memberService) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setName("Thoai");
		account.setLevel("sliver");
		accountService.addAccount(account, true);
		accountService.doWork();
		memberService.addSillyMember();
		memberService.goToSleep();
		
		//call the accountService  getter/setter methods
		System.out.println("=============call the accountService  getter/setter methods===============");
		accountService.setName("foobar");
		accountService.setServiceCode("sliver");
		String name =accountService.getName();
		String code = accountService.getServiceCode();
	}
}
