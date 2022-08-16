package com.coforge.training.airline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.UPI;
import com.coforge.training.airline.repository.UPIRepository;
import com.coforge.training.airline.service.UPIService;

@Service
public class UPIServiceImpl implements UPIService{

	@Autowired
	private UPIRepository repo;

	@Override
	public UPI saveUPI(UPI upi) {
		// TODO Auto-generated method stub
		return repo.save(upi);
	}

	@Override
	public List<UPI> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean verify(String upiid) {
		// TODO Auto-generated method stub
		return repo.existsById(upiid);
	}

	@Override
	public Boolean verifyByUPIData(UPI upi) {
		// TODO Auto-generated method stub
		return repo.existsByUpiidAndCode(upi.getUpiid(),upi.getCode());
	}
	
}
