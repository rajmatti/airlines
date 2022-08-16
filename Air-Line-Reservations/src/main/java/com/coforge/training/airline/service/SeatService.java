package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.Seats;
import com.coforge.training.airline.response.SeatAvailableResponse;
import com.coforge.training.airline.response.VerifySeatResponse;

public interface SeatService {

	List<Seats> getBookFlightSeatData(long flightid, String seattype);

	List<Seats> getFlightBySeats(long flightid);

	String deleteById(long seatid);

	SeatAvailableResponse getBookdataByFlightSeatData(long flightid, String seattype);

	VerifySeatResponse verify(long flightid, List<Seats> seat);

}
