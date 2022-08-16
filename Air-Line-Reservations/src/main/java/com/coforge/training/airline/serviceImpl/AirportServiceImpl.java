package com.coforge.training.airline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.AirPort;
import com.coforge.training.airline.random.RandomNoGenerator;
import com.coforge.training.airline.repository.AdminContentRepo;
import com.coforge.training.airline.repository.AirPortRepo;
import com.coforge.training.airline.response.AirPortSaveResponse;
import com.coforge.training.airline.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{

	@Autowired
	private AirPortRepo repo;

	@Autowired
	private AdminContentRepo adminrepo;
	
	@Override
	public AirPortSaveResponse saveAirport(AirPort airport) {
		AirPortSaveResponse res=new AirPortSaveResponse();
		
		if(adminrepo.existsById(airport.getAdminemail()))
		{
			
			
			RandomNoGenerator rand=new RandomNoGenerator();
			
			airport.setAirportid(rand.getRamdomNumber());
			
			res.setAirport(repo.save(airport));
			res.setMessage("AirPort Save");
		}
		else
		{
			res.setMessage("Admin is not valid");
		}
		
		return res;
	}

	@Override
	public AirPort getAirPortById(long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<AirPort> getAllAirport() {
		return repo.findAll();
	}

	@Override
	public List<AirPort> getAirPortByEmail(String adminemail) {
		return repo.findByAdminemail(adminemail);
	}

	@Override
	public AirPortSaveResponse updateAirport(long id, AirPort airport) {
		AirPortSaveResponse res=new AirPortSaveResponse();
		
		if(repo.existsById(id))
		{
			res.setAirport(repo.save(airport));
			res.setMessage("Airport is update");
		}
		else
		{
			res.setMessage("Id is not exist");
		}
		
		return res;
	}

	@Override
	public String deleteAirport(long id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return "Airport is delete";
		}
		return "Airport is not exist";
	}

}
