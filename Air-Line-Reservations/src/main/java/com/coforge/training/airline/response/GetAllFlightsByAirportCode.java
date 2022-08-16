package com.coforge.training.airline.response;

import java.util.List;

import com.coforge.training.airline.model.AirPort;
import com.coforge.training.airline.model.Flight;

import lombok.Data;

@Data
public class GetAllFlightsByAirportCode {

	private String message;
	
	private AirPort airport;
	
	private List<Flight> flight;
	
}
