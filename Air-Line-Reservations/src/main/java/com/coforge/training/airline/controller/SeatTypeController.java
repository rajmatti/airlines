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

import com.coforge.training.airline.model.seatType;
import com.coforge.training.airline.response.SeatTypeUpdateResponse;
import com.coforge.training.airline.service.SeatTypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/seattype")
public class SeatTypeController {

	@Autowired
	private SeatTypeService service;
	
//	Save Seat
//	URL -> http://localhost:8090/seattype
//	{
//	    "seattypename": "Economic",
//	    "seattypecode": "EC"
//	}
//	{
//	    "seattypename": "Premium Economy Class",
//	    "seattypecode": "PC"
//	}
//	{
//	    "seattypename": "Business Class",
//	    "seattypecode": "EC"
//	}
//	{
//	    "seattypename": "First-Class",
//	    "seattypecode": "FC"
//	}
	@PostMapping()
	public ResponseEntity<seatType> saveNewSeat(@RequestBody seatType seat)
	{
		seatType res=service.saveNewSeat(seat);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Get all Seats list
//	URL -> http://localhost:8090/seattype/getall
	@GetMapping("/getall")
	public ResponseEntity<List<seatType>> getAll()
	{
		List<seatType> res=service.getAll();
		return ResponseEntity.ok().body(res);
	}
	
	
//	Get seat by id
//	URL -> http://localhost:8090/seattype/getbyone/80
	@GetMapping("/getbyone/{seattypeid}")
	public ResponseEntity<seatType> getByOne(@PathVariable("seattypeid") long seattypeid)
	{
		seatType res=service.getByOne(seattypeid);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Update your Seats
//	URL -> http://localhost:8090/seattype/80
//	{
//	    "seattypeid": 81,
//	    "seattypename": "First Class",
//	    "seattypecode": "FC"
//	}
	@PutMapping("/{seattypeid}")
	public ResponseEntity<SeatTypeUpdateResponse> update(@PathVariable("seattypeid") long seattypeid, @RequestBody seatType seat)
	{
		SeatTypeUpdateResponse res=service.update(seattypeid, seat);
		return ResponseEntity.ok().body(res);
	}
	
	
//	Delete Seats
//	URL -> http://localhost:8090/seattype/81
	@DeleteMapping("/{seattypeid}")
	public ResponseEntity<String> deleteMap(@PathVariable("seattypeid") long seattypeid)
	{
		String res=service.deleteMap(seattypeid);
		return ResponseEntity.ok().body(res);
	}
	
	
}
