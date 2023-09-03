package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping({"/","/home"})
	public String showHome(Model model) {
		model.addAttribute("pageTitle","Home Page");
		return "home";
	}
	@GetMapping("/admin")
	public String showAdmin(Model model) {
		model.addAttribute("pageTitle","Admin Page");
		return "admin-page";
	}
	@GetMapping("/leaders")
	public String showleaders(Model model) {
		model.addAttribute("pageTitle","leaders Page");
		return "leaders";
	}
}
