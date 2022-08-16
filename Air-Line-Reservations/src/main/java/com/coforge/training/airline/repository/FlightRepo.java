package com.coforge.training.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.model.Seats;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long>{

	public List<Flight> findByAdminemail(String adminemail);

	public boolean existsByAdminemail(String adminemail);

	public List<Seats> findByFlightid(long flightid);

	public List<Flight> findAllByAirportid(long airportcode);

}
