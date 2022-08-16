package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.AirPort;
import com.coforge.training.airline.response.AirPortSaveResponse;

public interface AirportService {

	AirPortSaveResponse saveAirport(AirPort airport);

	AirPort getAirPortById(long id);

	List<AirPort> getAllAirport();

	List<AirPort> getAirPortByEmail(String adminemail);

	AirPortSaveResponse updateAirport(long id, AirPort airport);

	String deleteAirport(long id);
}
