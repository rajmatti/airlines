package com.coforge.training.airline.response;

import java.util.List;

import com.coforge.training.airline.model.BookFlightSeatData;

import lombok.Data;


@Data
public class BookFlightSeatDataAllListResponse {

	private String message;
	
	private boolean check;
	
	private int totalseats;
	
	private List<BookFlightSeatData> seats;
	
}
