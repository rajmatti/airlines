package com.coforge.training.airline.response;

import com.coforge.training.airline.model.Flight;

import lombok.Data;

@Data
public class FlightSaveResponse {

	private String message;
	
	private String email;
	
	private boolean status;
	
	private Flight fligth;
	
}
