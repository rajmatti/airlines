package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.response.FlightSaveResponse;
import com.coforge.training.airline.response.GetAllFlightsByAirportCode;

public interface FlightService {

	FlightSaveResponse saveFlight(Flight flight);

	List<Flight> getAllFlight();

	Flight getOneFlight(long flightid);

	FlightSaveResponse updateFlight(long flightid, Flight flight);

	String deleteFlight(long flightid);

	List<Flight> getFlightByUser(String adminemail);

	GetAllFlightsByAirportCode getAllFlightsByAirport(long airportcode);

}
