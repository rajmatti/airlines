package com.coforge.training.airline.response;

import com.coforge.training.airline.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterNewUser {

	private String message;
	
	private String email;
	
	private User user;
	
	
}
