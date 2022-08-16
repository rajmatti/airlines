package com.coforge.training.airline.response;

import java.util.List;

import com.coforge.training.airline.model.Seats;

import lombok.Data;

@Data
public class SeatAvailabilityListResponse {

	private String message;
	
	private boolean check;
	
	private long flightid;
	
	private List<Seats> seats;
	
}
