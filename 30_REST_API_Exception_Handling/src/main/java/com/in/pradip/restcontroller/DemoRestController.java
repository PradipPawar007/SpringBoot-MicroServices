package com.in.pradip.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoRestController {

	@GetMapping("Welcome")
	public String getWelcomeMsg() {
		String msg = "Welcome to REST_API";
		int num = 10/0;
		return msg;
	}
}
