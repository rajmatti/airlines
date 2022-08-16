package com.coforge.training.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.airline.model.UPI;
import com.coforge.training.airline.service.UPIService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/upi")
public class UPIController {

	@Autowired
	private UPIService service;
	
//	Save
//	URL -> http://localhost:8090/upi
//	{
//	    "upiid": "VikasDhiman213@upi",
//	    "code": 1233
//	}
	@PostMapping()
	public ResponseEntity<UPI> saveUPI(@RequestBody UPI upi)
	{
		UPI res=service.saveUPI(upi);
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping()
	public ResponseEntity<List<UPI>> getAllUPI()
	{
		List<UPI> res=service.getAll();
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping("/verifuupi/{upiid}")
	public ResponseEntity<Boolean> verifyUPI(@PathVariable("upiid") String upiid)
	{
		boolean res=service.verify(upiid);
		return ResponseEntity.ok().body(res);
	}
	
	@PostMapping("/verifyupibycode")
	public ResponseEntity<Boolean> verifyUPIData(@RequestBody UPI upi)
	{
		Boolean res=service.verifyByUPIData(upi);
		return ResponseEntity.ok().body(res);
	}
	
}
