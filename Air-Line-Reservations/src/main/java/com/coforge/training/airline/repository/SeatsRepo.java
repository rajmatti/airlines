package com.coforge.training.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.BookFlightSeatData;
import com.coforge.training.airline.model.Seats;

@Repository
public interface SeatsRepo extends JpaRepository<Seats, Long>{

	public List<Seats> findByFlightid(long flightid);

	public boolean deleteByFlightid(long flightid);

	public List<Seats> findAllByFlightid(long flightid);

	public Seats findByFlightidAndSeattype(long flightid, String seatType);

	public List<Seats> findAllByFlightidAndSeattype(long flightid, String seattype);

}
