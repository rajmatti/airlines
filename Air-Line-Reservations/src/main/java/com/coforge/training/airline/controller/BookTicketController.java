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

import com.coforge.training.airline.model.BookTickets;
import com.coforge.training.airline.response.BookTicketSaveResponse;
import com.coforge.training.airline.service.BookTicketService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bookticket")
public class BookTicketController {

	@Autowired
	private BookTicketService service;
	
	
	
//	Book Ticket 
//	URL -> http://localhost:8090/bookticket/
//	{
//	    "flightid": 250327208,
//	    "userid": 100,
//	    "email": "vikasdhiman835@gmail.com",
//	    "ticketpaymentmethod": "UPI",
//	    "paymentstatus": {
//	        "upiid": "vikas@upi",
//	        "totalamount": 900.45,
//	        "paidamount": 900.45,
//	        "paymentstatus": "Success"
//	    },
//	    "bookseats": [
//	        {
//	            "name": "Vikas Dhiman",
//	            "email": "vikasdhiman835@gmail.com",
//	            "phoneno": "9090900909",
//	            "passportno": "ASPOD0912",
//	            "country": "India",
//	            "gender": "Male",
//	            "seattype": "First Class",
//				"price": 7000
//	        },
//	        {
//	            "name": "ABC",
//	            "email": "abc@gmail.com",
//	            "phoneno": "567895678",
//	            "passportno": "ASPOD09101",
//	            "country": "India",
//	            "gender": "Male",
//	            "seattype": "First Class",
//				"price": 7000
//	        }
//	    ]
//	}
	@PostMapping()
	public ResponseEntity<BookTicketSaveResponse> saveBookTicket(@RequestBody BookTickets ticket)
	{
		BookTicketSaveResponse res=service.saveBookTicket(ticket);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get All tickets 
	 * URL -> http://localhost:8090/bookticket/alltickets
	 */
	@GetMapping("/alltickets")
	public ResponseEntity<List<BookTickets>> getAllTickets()
	{
		List<BookTickets> res=service.getAllTickets();
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get Ticket By id 
	 * URL -> http://localhost:8090/bookticket/getticketbyid/654247535
	 */
	@GetMapping("/getticketbyid/{bookid}")
	public ResponseEntity<BookTickets> getTicketById(@PathVariable("bookid") long bookid)
	{
		BookTickets res=service.getBookTicketById(bookid);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get Ticket By Flight Id 
	 * URL ->http://localhost:8090/bookticket/getticketbyflight/250327208
	 */
	@GetMapping("/getticketbyflight/{flightid}")
	public ResponseEntity<List<BookTickets>> getTicketByFlightId(@PathVariable("flightid") long flightid)
	{
		List<BookTickets> res=service.getTicketByFlightId(flightid);
		return ResponseEntity.ok().body(res);
	}
	
	
	
	/*
	 * Get Ticket By User Id 
	 * URL -> http://localhost:8090/bookticket/getticketbyuserid/100
	 */
	@GetMapping("/getticketbyuserid/{userid}")
	public ResponseEntity<List<BookTickets>> getTicketByUserId(@PathVariable("userid") long userid)
	{
		List<BookTickets> res=service.getBookTicketsByUserId(userid);
		return ResponseEntity.ok().body(res);
	}

	
	
	/*
	 * Get All Tickets By Email 
	 * URL -> http://localhost:8090/bookticket/getticketbyemail/vikasdhiman835@gmail.com
	 */
	@GetMapping("/getticketbyemail/{email}")
	public ResponseEntity<List<BookTickets>> getAllTicketsByEmail(@PathVariable("email") String email)
	{
		List<BookTickets> res=service.getAllTicketsByEmail(email);
		return ResponseEntity.ok().body(res);
	}
	
	/* Get Flight By id */
	@GetMapping("/getbyid/{bookid}")
	public ResponseEntity<BookTickets> getByid(@PathVariable("bookid") long bookid)
	{
		BookTickets res=service.getBookById(bookid);
		return ResponseEntity.ok().body(res);
	}
	
}
