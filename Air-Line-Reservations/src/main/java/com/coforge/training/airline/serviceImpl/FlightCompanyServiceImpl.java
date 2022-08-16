package com.coforge.training.airline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.FlightCompany;
import com.coforge.training.airline.repository.FlightCompanyRepo;
import com.coforge.training.airline.response.UpdateFlightCompanyResponse;
import com.coforge.training.airline.service.FlightCompanyService;

@Service
public class FlightCompanyServiceImpl implements FlightCompanyService {

	@Autowired
	private FlightCompanyRepo repo;

	@Override
	public FlightCompany newFlight(FlightCompany flight) {
		// TODO Auto-generated method stub
		return repo.save(flight);
	}

	@Override
	public List<FlightCompany> getAllCompany() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public FlightCompany getCompanyById(long companyid) {
		// TODO Auto-generated method stub
		return repo.findById(companyid).get();
	}

	@Override
	public String deleteCompany(Long companyid) {
		repo.deleteById(companyid);
		if(repo.existsById(companyid))
		{
			return "Company Exist";
		}
		return "Company removed";
	}

	@Override
	public UpdateFlightCompanyResponse updatecompany(long companyid, FlightCompany fCompany) {
		UpdateFlightCompanyResponse res=new UpdateFlightCompanyResponse();

		if(repo.existsById(companyid))
		{
			FlightCompany updatecompany=repo.save(fCompany);

			res.setMessage("Company name  is updated");

			res.setCheck(true);
			res.setCompanyname(updatecompany.getCompanyname());
			res.setFCompany(updatecompany);
		}
		else
		{
			res.setMessage("Comoany  id is not exist");
			res.setCheck(false);
			res.setCompanyname(fCompany.getCompanyname());
		}

		return res;
	}

	@Override
	public FlightCompany getCompany(String company) {
		// TODO Auto-generated method stub
		return repo.findByCompanyname(company);
	}

	@Override
	public List<FlightCompany> getCompanyByCountry(String country) {
		// TODO Auto-generated method stub
		return repo.findByCountry(country);
	}

	@Override
	public List<FlightCompany> getFlightByCountryCode(String code) {
		// TODO Auto-generated method stub
		return repo.findByCode(code);
	}


	@Override
	public FlightCompany getCompanyByCompany(String company) {
		return repo.findByCompanyname(company);
	}

}
