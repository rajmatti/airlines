package com.coforge.training.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.FlightCompany;

@Repository
public interface FlightCompanyRepo extends JpaRepository<FlightCompany, Long>{

	FlightCompany findByCompanyname(String company);

	List<FlightCompany> findByCountry(String cont);

	List<FlightCompany> findByCode(String code);


}
