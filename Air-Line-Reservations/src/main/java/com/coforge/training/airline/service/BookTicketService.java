package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.BookTickets;
import com.coforge.training.airline.response.BookTicketSaveResponse;

public interface BookTicketService {

	BookTicketSaveResponse saveBookTicket(BookTickets ticket);

	List<BookTickets> getAllTickets();

	BookTickets getBookTicketById(long bookid);

	List<BookTickets> getTicketByFlightId(long flightid);

	List<BookTickets> getBookTicketsByUserId(long userid);

	List<BookTickets> getAllTicketsByEmail(String email);

	BookTickets getBookById(long bookid);


}
