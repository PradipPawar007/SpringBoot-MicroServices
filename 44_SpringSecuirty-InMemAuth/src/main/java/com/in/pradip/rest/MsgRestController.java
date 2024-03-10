package com.in.pradip.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/contact")
	public String contact() {
		return "Cantact Us :: +91 -9023 231 332 ";
	}	

	@GetMapping("/greet")
	public String greetMsg() {
		return "Good Eevening";
	}
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to security App";
	}
}
