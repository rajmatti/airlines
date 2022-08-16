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

import com.coforge.training.airline.model.Card;
import com.coforge.training.airline.service.CardService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService service;
	
	
//	Save data
//	URL -> http://localhost:8090/card
//	{
//	    "cardno": 90854567898,
//	    "recardno": 90854567898,
//	    "cvv": 289,
//	    "name" : "Vikas",
//	    "code": 1237
//	}
	@PostMapping()
	public ResponseEntity<Card> save(@RequestBody Card card)
	{
		Card res=service.saveCard(card);
		return ResponseEntity.ok().body(res);
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Card>> getAllCard()
	{
		List<Card> res=service.getCard();
		return ResponseEntity.ok().body(res);
	}
	
	
	@GetMapping("/getbyid/{cardno}")
	public ResponseEntity<Boolean> verifyCard(@PathVariable("cardno") long cardno)
	{
		Boolean res=service.verifycard(cardno);
		return ResponseEntity.ok().body(res);
	}
	
	
	@PostMapping("/verify")
	public ResponseEntity<Boolean> verify(@RequestBody Card card)
	{
		boolean res=service.verifyCardDetails(card);
		System.out.println(res);
		return ResponseEntity.ok().body(res);
	}
	
	@PostMapping("/verifybycode")
	public ResponseEntity<Boolean> verifyByCode(@RequestBody Card card)
	{
		Boolean res=service.verifyByCode(card);
		return ResponseEntity.ok().body(res);
	}
	
}
