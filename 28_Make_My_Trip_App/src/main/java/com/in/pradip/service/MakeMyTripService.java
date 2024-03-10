package com.in.pradip.service;

import com.in.pradip.request.Passenger;
import com.in.pradip.response.Ticket;

public interface MakeMyTripService {

	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicketByNum(Integer ticketNuber);
}
