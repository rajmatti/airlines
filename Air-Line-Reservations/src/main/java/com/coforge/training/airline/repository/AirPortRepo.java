package com.coforge.training.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.training.airline.model.AirPort;

@Repository
public interface AirPortRepo extends JpaRepository<AirPort, Long>{

	List<AirPort> findByAdminemail(String adminemail);
}
