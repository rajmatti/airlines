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

import com.coforge.training.airline.model.AirPort;
import com.coforge.training.airline.response.AirPortSaveResponse;
import com.coforge.training.airline.service.AirportService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/airport")
public class AirPortController {

	
	@Autowired
	private AirportService service;
	
	
	/*
	 * Save method 
	 * URL -> http://localhost:8090/airport 
	 * { 
	 * 		"airportname": "Mumbai",
	 * 		"airportcountry": "India", 
	 * 		"airportcity": "Mumbai", 
	 * 		"airportpincode":"123341", 
	 * 		"airportphoneno": "090909090909", 
	 * 		"adminemail":"vikasdhiman835@gmail.com" 
	 * }
	 */
	@PostMapping()
	public ResponseEntity<AirPortSaveResponse> saveAirport(@RequestBody AirPort airport)
	{
		AirPortSaveResponse res=service.saveAirport(airport);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get Method by id 
	 * URL -> http://localhost:8090/airport/726189078
	 */
	@GetMapping("/{id}")
	public ResponseEntity<AirPort> getAirportById(@PathVariable("id") long id)
	{
		AirPort res=service.getAirPortById(id);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get All Airport 
	 * URL -> http://localhost:8090/airport/
	 */
	@GetMapping()
	public ResponseEntity<List<AirPort>> getAllAirPort()
	{
		List<AirPort> res=service.getAllAirport();
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get Airport By Admin Email 
	 * URL -> http://localhost:8090/airport/getbyadmin/vikasdhiman@gmail.com
	 */
	@GetMapping("/getbyadmin/{adminemail}")
	public ResponseEntity<List<AirPort>> getAirPortByEmail(@PathVariable("adminemail") String adminemail)
	{
		List<AirPort> res=service.getAirPortByEmail(adminemail);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Update Airport 
	 * URL -> http://localhost:8090/airport/909792732 
	 * { 
	 * 		"airportid":909792732, 
	 * 		"airportname": "Mumbai", 
	 * 		"airportcountry": "India", 
	 * 		"airportcity":"Mumbai", 
	 * 		"airportpincode": "123341", 
	 * 		"airportphoneno": "090909090909",
	 * 		"adminemail": "vikasdhiman835@gmail.com" 
	 * }
	 */
	@PutMapping("/{id}")
	public ResponseEntity<AirPortSaveResponse> updateAirport(@PathVariable("id") long id, @RequestBody AirPort airport)
	{
		AirPortSaveResponse res=service.updateAirport(id,airport);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Delete Airport 
	 * URL -> http://localhost:8090/airport/909792732
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAirport(@PathVariable("id") long id)
	{
		String res=service.deleteAirport(id);
		return ResponseEntity.ok().body(res);
	}
	

}
