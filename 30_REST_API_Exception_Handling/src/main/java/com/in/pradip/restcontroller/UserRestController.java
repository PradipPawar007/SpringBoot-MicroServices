package com.in.pradip.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in.pradip.exception.UserNotFoundException;

@RestController
public class UserRestController {

	@GetMapping("user/{userId}")
	public String getUserName(@PathVariable("userId") Integer userId) {
	
		if(userId  == 100) {
			return "Pradip";
		}else if (userId == 200) {
			return "Akash";
		}else {
			throw new UserNotFoundException("User Not Found...!");
		}
	
	}
}
