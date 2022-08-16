package com.coforge.training.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.airline.model.AdminContent;
import com.coforge.training.airline.service.AdminContentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admincontent")
public class AdminContentController {

	@Autowired
	private AdminContentService service;
	
	/*
	 * Create a new Admin
	 * URL -> http://localhost:8090/admincontent
	 * {
	 * 		"adminemail": "admin@gmail.com"
	 * }
	 * */
	@PostMapping()
	public ResponseEntity<AdminContent> save(@RequestBody() AdminContent admin)
	{
		AdminContent res=service.newAdmin(admin);
		return ResponseEntity.ok().body(res);
	}
	
	/*
	 * Get all admin how many admin in database
	 * URL -> http://localhost:8090/admincontent
	*/
	@GetMapping()
	public ResponseEntity<List<AdminContent>> getAllAdmin()
	{
		List<AdminContent> res=service.getAllAdmin();
		return ResponseEntity.ok().body(res);
	}
	
	/*
	 * Get data by email using 
	 * URL -> http://localhost:8090/admincontent/admin@gmail.com
	 * */
	@GetMapping("/{email}")
	public ResponseEntity<AdminContent> getOneAdmin(@PathVariable("email") String email)
	{
		AdminContent res=service.getOneAdmin(email);
		return ResponseEntity.ok().body(res);
	}
	
	/*
	 * Delete Admin by Admin in Database URL ->
	 * http://localhost:8090/admincontent/admin@gmail.com
	 */	
	@DeleteMapping("/{email}")
	public ResponseEntity<String> deleteMapping(@PathVariable("email") String email)
	{
		String res=service.deleteAdmin(email);
		return ResponseEntity.ok().body(res);
	}
	
}
