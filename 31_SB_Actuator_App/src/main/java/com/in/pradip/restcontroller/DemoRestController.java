package com.in.pradip.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/actuator")
	public String getMsg(){
		return "Welcome to REST_API";
	}
}
