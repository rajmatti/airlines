package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.BookFlightSeatData;
import com.coforge.training.airline.response.BookFlightSeatDataAllListResponse;
import com.coforge.training.airline.response.SeatAvailabilityListResponse;

public interface BookFlightSeatDataService {

	BookFlightSeatData getById(long bookflightseatid);

	BookFlightSeatDataAllListResponse getAllSeatsByFlight(long flightid);

	SeatAvailabilityListResponse checkAllAvailability(long flightid);

	List<BookFlightSeatData> getBookFlightSeatData(long flightid, String seattype);


}
