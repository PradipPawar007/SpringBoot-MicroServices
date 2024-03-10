package com.in.pradip.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.pradip.binding.User;


@RestController
public class UserController {

	private Map<Integer,User> dataMap = new HashMap<>();
	
	@PostMapping(
			value ="/user",
			consumes = { "application/json" } // in which format rest api accept input data like json,xml we can specify
			)
	public ResponseEntity<String> addUsers(@RequestBody User user){
		System.out.println(user);
		dataMap.put(user.getId(), user);
		return new ResponseEntity<String>("User Saved",HttpStatus.CREATED);
	}
	
	//http://localhost:8080/user?userid=201    browser/postman url --> Query Parameter
	@GetMapping(
			value = "/user",
			produces = { " application/json " } // in which format rest api provide output data like json,xml we can specify
			)
	public User getUser(@RequestParam("userid") Integer userId) {
		User user = dataMap.get(userId);
		return user;
	}
	
	//http://localhost:8080/user?userid=201&name=pradip    browser/postman url --> Query Parameter -> multiple prarameter
//	@GetMapping("/user")
	public User getUserData(@RequestParam("userid") Integer userId,@RequestParam("name") String Name) {
		User user = dataMap.get(userId);
		return user;
	}
	//http://localhost:8080/user/202/data   browser/postman url --> Path Parameter
	@GetMapping("user/{id}/data")
	public User getUserDataById(@PathVariable("id") Integer userId) {
		User user = dataMap.get(userId);
		return user;
	}
}
