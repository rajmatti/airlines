package com.coforge.training.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.airline.model.UPI;

public interface UPIRepository extends JpaRepository<UPI, String>{

	Boolean existsByUpiidAndCode(String upiid, int code);

}
