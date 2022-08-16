package com.coforge.training.airline.service;

import java.util.List;
import com.coforge.training.airline.model.FlightCompany;
import com.coforge.training.airline.response.UpdateFlightCompanyResponse;


public interface FlightCompanyService {

	public FlightCompany newFlight(FlightCompany flight);

	public List<FlightCompany> getAllCompany();

	public FlightCompany getCompanyById(long companyid);

	public String deleteCompany(Long companyid);

	public UpdateFlightCompanyResponse updatecompany(long userid, FlightCompany fCompany);

	public FlightCompany getCompany(String company);

	public List<FlightCompany> getCompanyByCountry(String country);

	public List<FlightCompany> getFlightByCountryCode(String code);

	public FlightCompany getCompanyByCompany(String company);

}
