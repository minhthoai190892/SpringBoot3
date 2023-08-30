package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullRestController {
	@GetMapping({"/","home"})
	public String sayHello() {
		return "Hello Spring boot";
	}
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
}



