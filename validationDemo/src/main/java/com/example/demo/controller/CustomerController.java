package com.example.demo.controller;

import java.security.PublicKey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	@GetMapping("/")
	public String showCustomer(Model model) {
		System.err.println("showCustomer");
		model.addAttribute("customer",new Customer());
		model.addAttribute("pageTitle","Show Form");
		return "customer-form";
	}
	@PostMapping("/processForm")
	public String showCustomer(@Valid @ModelAttribute("customer")Customer customer,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-confirmation";
		}
	}
}
