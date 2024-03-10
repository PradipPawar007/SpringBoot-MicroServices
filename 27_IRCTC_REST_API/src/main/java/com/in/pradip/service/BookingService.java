package com.in.pradip.service;

import com.in.pradip.request.Passenger;
import com.in.pradip.response.Ticket;

public interface BookingService {

	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);
}
