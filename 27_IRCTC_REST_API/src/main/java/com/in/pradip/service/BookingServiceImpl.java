package com.in.pradip.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.in.pradip.request.Passenger;
import com.in.pradip.response.Ticket;


@Service
public class BookingServiceImpl implements BookingService {

	private Map<Integer,Ticket> ticketMap = new HashMap<>();
	private Integer ticketNumber = 1;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		// logic
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(430.00);
		t.setStatus("COFIORMED");
		t.setTicketNum(ticketNumber);

		ticketMap.put(ticketNumber, t);
		
		ticketNumber++;
		
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		if(ticketMap.containsKey(ticketNumber)) {
			return ticketMap.get(ticketNumber);
		}
		return null;
	}

}
