package com.coforge.training.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.airline.model.User;
import com.coforge.training.airline.request.VerifyUserCrenditials;
import com.coforge.training.airline.response.LoginUserResponse;
import com.coforge.training.airline.response.RegisterNewUser;
import com.coforge.training.airline.response.UpdateUserPasswordResponse;
import com.coforge.training.airline.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class LoginController 
{
	
	@Autowired
	private LoginService service;
	
	/*
	 * Register New user 
	 * URL -> http://localhost:8090/user/save
	 * {
	 * "email": "vikasdhi@gmail.com",
	 * "firstname": "vikas",
	 * "lastname": "dhiman",
	 * "mobileno": "909090909",
	 * "password": "vikas"
	 * }
	 * */
	@PostMapping("/save")
	public ResponseEntity<RegisterNewUser> registerNewUser(@RequestBody User user)
	{
		RegisterNewUser res=service.registerNewUser(user);
		return ResponseEntity.ok().body(res);
	}
	
	/*
	 * Login User using email and password
	 * URL -> http://localhost:8090/user/login
	 * {
	 * "email": "vikas@gmail.com",
	 * "password": "vikas"
	 * }
	 * 
	 * */
	@PostMapping("/login")
	public ResponseEntity<LoginUserResponse> loginUser(@RequestBody User user)
	{
		LoginUserResponse res=service.loginUser(user);
		return ResponseEntity.ok().body(res);
	}
	
	/*
	 * Get By User Id 
	 * URL -> http://localhost:8090/user/getbyid/100
	 */
	@GetMapping("/getbyid/{userid}")
	public ResponseEntity<User> getByUserID(@PathVariable("userid") long userid)
	{
		User res=service.getUserById(userid);
		return ResponseEntity.ok().body(res);
	}
	
	/*
	 * Get By User Email URL ->
	 * http://localhost:8090/user/getbyemail/vikasdhiman835@gmail.com
	 */
	@GetMapping("/getbyemail/{email}")
	public ResponseEntity<User> getByEmail(@PathVariable("email") String email)
	{
		User res=service.getUserByEmail(email);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * Get All Users 
	 * URL -> http://localhost:8090/user/getall
	 * */
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> res=service.getAllUser();
		return ResponseEntity.ok().body(res);
	}

	/*
	 * Forget Password  work-------------------------------- 3 Steps
	 * 1. Verify Email
	 * Verify user By email 
	 * URL -> http://localhost:8090/user/verifyemail/vikasdhiman835@gmail.com
	 * 
	 * */
	@GetMapping("/verifyemail/{email}")
	public ResponseEntity<Boolean> verifyEmail(@PathVariable("email") String email)
	{
		boolean res=service.verifyEmail(email);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * 2. Verify Phone no and User Email. 
	 * URL -> http://localhost:8090/user/verifyforcrenditicals 
	 * { 
	 * 		"email": "ram@gmail.com",
	 * 		"phoneno": "909090909" 
	 * }
	 */
	@PostMapping("/verifyforcrenditicals")
	public ResponseEntity<Boolean> verifyforCrenditials(@RequestBody VerifyUserCrenditials verifydata)
	{
		boolean res=service.verifyUserdata(verifydata);
		return ResponseEntity.ok().body(res);
	}
	
	
	/*
	 * 3. Update Password 
	 * URL -> http://localhost:8090/user/updatepassword/vikasdhiman835@gmail.com 
	 * { 
	 * 		"email": "vikasdhiman835@gmail.com", 
	 * 		"phoneno": "0000000000", 
	 * 		"password":"vikasdhiman" 
	 * }
	 */
	@PutMapping("/updatepassword/{email}")
	public ResponseEntity<UpdateUserPasswordResponse> updatePassword(@PathVariable("email") String email, @RequestBody User updateduser)
	{
		UpdateUserPasswordResponse res=service.updatePassword(email, updateduser);
		return ResponseEntity.ok().body(res);
	}
	
}
