package com.in.pradip.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetRestController {
    
	/*this Environment for loadbalancing 
	 *  if we want this application on multiple port then follow below steps
	 *  Run -> run Configuration ->Select which app u want run in -> Boot Dashboard -> Argument -> vm argument -> -Dserver.port=8081 -> apply -> run
	 *  we can run multiple time  
	 *  */
	@Autowired
	private Environment eng;
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		String port = eng.getProperty("server.port");
		return "Good Evening....("+ port + ")";
	}
}
