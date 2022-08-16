package com.coforge.training.airline.response;

import com.coforge.training.airline.model.seatType;

import lombok.Data;

@Data
public class SeatTypeUpdateResponse {

	private String message;
	
	private seatType seat;
	
}
