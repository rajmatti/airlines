package com.coforge.training.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.BookFlightSeatData;

@Repository
public interface BookFlightSeatDataRepo extends JpaRepository<BookFlightSeatData, Long>{

	boolean existsByFlightid(long flightid);

	List<BookFlightSeatData> findAllByFlightid(long flightid);

	List<BookFlightSeatData> findByFlightidAndSeattype(long flightid, String seattype);

}
