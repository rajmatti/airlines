package com.coforge.training.airline.response;

import com.coforge.training.airline.model.BookTickets;

import lombok.Data;

@Data
public class BookTicketSaveResponse {

	private String message;
	
	private String email;
	
	private boolean check;
	
	private BookTickets bookticket;
	
}
