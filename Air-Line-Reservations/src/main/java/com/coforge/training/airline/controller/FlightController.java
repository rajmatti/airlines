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

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.response.FlightSaveResponse;
import com.coforge.training.airline.response.GetAllFlightsByAirportCode;
import com.coforge.training.airline.service.FlightService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/flight")
public class FlightController {

	
	@Autowired
	private FlightService service;
	
	
//	Save Flight 
//	URL -> http://localhost:8090/flight
//	{
//	    "flightname": "IndiGo",
//	    "flightfrom": "Delhi",
//	    "flightto": "Mumbai",
//	    "flightfromtime": "10:00 PM",
//	    "flighttotime": "00:00 AM",
//	    "flightstatus": "Active",
//	    "flightgateno": "5",
//	    "flightfromdate": "31-12-2021",
//	    "flighttodate": "01-01-2022",
//	    "flightcompanyname": "IndiGo",
//	    "airportid": "726189078",
//	    "adminemail": "vikasdhiman835@gmail.com",
//	    "flightseats": [
//	        {
//	            "seatType": "Echonomic",
//	            "totalseats": "60",
//	            "seatprize": 4000
//	        },
//	        {
//	            "seatType": "Bussiness Class",
//	            "totalseats": "30",
//	            "seatprize": 8000
//	        },
//	        {
//	            "seatType": "First Class",
//	            "totalseats": "10",
//	            "seatprize": 12000
//	        }
//	    ]
//	}
	@PostMapping()
	public ResponseEntity<FlightSaveResponse> saveFlight(@RequestBody Flight flight)
	{
		FlightSaveResponse res=service.saveFlight(flight);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Get All flights into database
//	URL -> http://localhost:8090/flight
	@GetMapping()
	public ResponseEntity<List<Flight>> getAllFlight()
	{
		List<Flight> res=service.getAllFlight();
		return ResponseEntity.ok().body(res);
	}
	
	
	
//	Get flight by Flight id
//	URL -> http://localhost:8090/flight/flightbyid/26283476
	@GetMapping("/flightbyid/{flightid}")
	public ResponseEntity<Flight> getOneById(@PathVariable("flightid") long flightid)
	{
		Flight res=service.getOneFlight(flightid);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Update flight By id
//	URL -> http://localhost:8090/flight/612853812
//	{
//	    "flightid": 612853812,
//	    "flightname": "indgo",
//	    "flightfrom": "Delhi",
//	    "flightto": "Mumbai",
//	    "flightfromtime": "10:00 PM",
//	    "flighttotime": "00:00 AM",
//	    "flightstatus": "Active",
//	    "flightgateno": "5",
//	    "flightfromdate": "31-12-2021",
//	    "flighttodate": "01-01-2022",
//	    "flightcompanyname": "IndiGo",
//		"airportid": "923993932",
//	    "adminemail": "vikasdhiman835@gmail.com",
//	    "flightseats": [
//	        {
//	            "seatid": 62,
//	            "seatType": "Echonomic",
//	            "totalseats": "60",
//	            "seatprize": 4000.0,
//	            "flightid": 612853812
//	        },
//	        {
//	            "seatid": 63,
//	            "seatType": "Bussiness Class",
//	            "totalseats": "30",
//	            "seatprize": 8000.0,
//	            "flightid": 612853812
//	        }
//	    ]
//	}
	@PutMapping("/{flightid}")
	public ResponseEntity<FlightSaveResponse> updateFlight(@PathVariable("flightid") long flightid, @RequestBody Flight flight)
	{
		FlightSaveResponse res=service.updateFlight(flightid, flight);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Delete flight By Id
//	URL -> http://localhost:8090/flight/612853812
	@DeleteMapping("/{flightid}")
	public ResponseEntity<String> deleteFlight(@PathVariable("flightid") long flightid)
	{
		String res=service.deleteFlight(flightid);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Get all flights by Admin
//	URL -> http://localhost:8090/flight/flightbyadmin/vikasdhiman835@gmail.com
	@GetMapping("/flightbyadmin/{adminemail}")
	public ResponseEntity<List<Flight>> getFlightByAllUsers(@PathVariable("adminemail") String adminemail)
	{
		List<Flight> res=service.getFlightByUser(adminemail);
		return ResponseEntity.ok().body(res);
	}
	
	
	
//	Get All flights by airport id
//	URL -> http://localhost:8090/flight/getallflightsbyairportcode/726189078
	@GetMapping("/getallflightsbyairportcode/{airportid}")
	public ResponseEntity<GetAllFlightsByAirportCode> getAllFlightByAirPortCode(@PathVariable("airportid") long airportcode)
	{
		GetAllFlightsByAirportCode res=service.getAllFlightsByAirport(airportcode);
		return ResponseEntity.ok().body(res);
	}
	
}
