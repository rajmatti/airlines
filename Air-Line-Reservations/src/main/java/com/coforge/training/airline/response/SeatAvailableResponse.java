package com.coforge.training.airline.response;

import lombok.Data;

@Data
public class SeatAvailableResponse {

	private long seatid;
	
	private String seattype;
	
	private int totalseats;
	
	private double seatprize;
	
	private long flightid;
	
	private int availableseat;
	
}
