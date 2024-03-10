package com.in.pradip.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.pradip.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetFeignClient greetClient;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String greetResp = greetClient.invokeGreet();
		return greetResp+"Welcome to REST API...!";
	}
}
