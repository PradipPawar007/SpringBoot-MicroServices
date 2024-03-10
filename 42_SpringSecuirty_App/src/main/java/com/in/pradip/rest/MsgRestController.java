package com.in.pradip.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/hi")
	public String sayHi() {
		return "Hi ' How are you ?.";
	}
	
	@GetMapping("/hlo")
	public String sayHlo() {
		return "Hlo ' How are you ?.";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Call us :: +91 803 212 1212";
	}
	
	@GetMapping("/logincheck")
	public String login() {
		return "login successfull..";
	}
}
