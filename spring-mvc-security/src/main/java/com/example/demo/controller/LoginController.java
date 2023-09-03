package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	public String showLogin() {
		return "plain-login";
	}
	@GetMapping("/access-denied")
	public String showaccessdenied(Model model) {
		model.addAttribute("pageTitle","Access denied");
		return "access-denied";
	}
}
