package com.in.pradip.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.in.pradip.request.Passenger;
import com.in.pradip.response.Ticket;

public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL  = "http://localhost:8080/ticket";
	private String GET_TICKET_URL =  "http://localhost:8080/ticket/{ticketNum}";
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Ticket> respTicket = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
        Ticket ticket = respTicket.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNuber) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respTicket = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNuber);
		Ticket ticket = respTicket.getBody();
		return ticket;
	}

}
