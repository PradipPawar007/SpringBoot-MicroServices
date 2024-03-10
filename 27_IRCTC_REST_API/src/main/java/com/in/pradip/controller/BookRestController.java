package com.in.pradip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.pradip.request.Passenger;
import com.in.pradip.response.Ticket;
import com.in.pradip.service.BookingServiceImpl;

@RestController
public class BookRestController {

	@Autowired
	private BookingServiceImpl service;
	
	@PostMapping(
		       value = "/ticket",
		       consumes = {"application/json"},
		       produces = {"application/json"} 
			)
	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger){
		Ticket t =  service.bookTicket(passenger);
		System.out.println(passenger);
	    return new ResponseEntity<Ticket>(t,HttpStatus.CREATED);	
	}

	@GetMapping(
			value = "/ticket/{ticketNum}",
			produces = { "application/json" }
		)
	public ResponseEntity<Ticket> getTicketByNum(@PathVariable("ticketNum") Integer ticketNumber) {
		Ticket t = service.getTicket(ticketNumber);
		System.out.println(t);
		return new ResponseEntity<Ticket>(t,HttpStatus.OK);
	}
}
