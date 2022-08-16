package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.UPI;

public interface UPIService {

	UPI saveUPI(UPI upi);

	List<UPI> getAll();

	boolean verify(String upiid);

	Boolean verifyByUPIData(UPI upi);

}
