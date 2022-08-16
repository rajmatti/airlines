package com.coforge.training.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.coforge.training.airline.model.FlightCompany;
import com.coforge.training.airline.response.UpdateFlightCompanyResponse;
import com.coforge.training.airline.service.FlightCompanyService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/flightcompany")
public class FlightCompanyController {

	@Autowired
	private FlightCompanyService service;


	//	Save Flight Company 
	//	URL -> http://localhost:8090/flightcompany/save
	//	{
	//	    "companyname": "Indgo",
	//	    "country": "India",
	//	    "code": "IN"
	//	}
	@PostMapping("/save")
	public ResponseEntity<FlightCompany> save(@RequestBody() FlightCompany flight)
	{
		FlightCompany company=service.newFlight(flight);
		return ResponseEntity.ok().body(company);
	}


	//	Get All Flight Company 
	//	URL -> http://localhost:8090/flightcompany/all
	@GetMapping("/all")
	public ResponseEntity<List<FlightCompany>> getAllCompany()
	{
		List<FlightCompany> company =service.getAllCompany();
		return ResponseEntity.ok().body(company);
	}


	//	get flight  by company id 
	//	URL -> http://localhost:8090/flightcompany/getflightcompanybyid/246
	@GetMapping("/getflightcompanybyid/{companyid}")
	public ResponseEntity<FlightCompany> getCompanyById(@PathVariable("companyid") long companyid)
	{
		FlightCompany f=service.getCompanyById(companyid);
		return ResponseEntity.ok().body(f);
	}


	//	get flight by company
	//	URL -> http://localhost:8090/flightcompany/getbycompanyname/Indgo
	@GetMapping("/getbycompanyname/{company}")
	public ResponseEntity<FlightCompany> getCompanyByCompany(@PathVariable("company") String company)
	{
		FlightCompany f=service.getCompanyByCompany(company);
		return ResponseEntity.ok().body(f);
	}


	//	get flight by country true
	//	URL -> http://localhost:8090/flightcompany/getflightcompanybycountry/India
	@GetMapping("/getflightcompanybycountry/{country}")
	public ResponseEntity<List<FlightCompany>> getCompanyByCountry(@PathVariable("country") String country)
	{
		List<FlightCompany> res=service.getCompanyByCountry(country);
		return ResponseEntity.ok().body(res);
	}


	//	Get flight by country code 
	//	URL -> http://localhost:8090/flightcompany/getflightcompanybycountrycode/IN
	@GetMapping("/getflightcompanybycountrycode/{code}")
	public ResponseEntity<List<FlightCompany>> getFlightByCountryCode(@PathVariable("code") String code)
	{
		List<FlightCompany> f=service.getFlightByCountryCode(code);
		return ResponseEntity.ok().body(f);
	}


	//	Delete Flight Company
	//	URL -> http://localhost:8090/flightcompany/246
	@DeleteMapping("/{companyid}")
	public ResponseEntity<String> deleteMapping(@PathVariable("companyid") Long companyid)
	{
		String f=service.deleteCompany(companyid);
		return ResponseEntity.ok().body(f);
	}


	//	Update Flight Company 
	//	URL -> http://localhost:8090/flightcompany/247
	//	{
	//	    "companyid": 247,
	//	    "companyname": "Indgo",
	//	    "country": "USA",
	//	    "code": "IN"
	//	}
	@PutMapping("/{companyid}")
	public ResponseEntity<UpdateFlightCompanyResponse> updatecompany(@PathVariable("companyid") long companyid, @RequestBody FlightCompany  fCompany)
	{
		UpdateFlightCompanyResponse f=service.updatecompany(companyid,fCompany);
		return ResponseEntity.ok().body(f);
	}



}
