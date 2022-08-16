package com.coforge.training.airline.response;

import com.coforge.training.airline.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserResponse {

	private String message;
	
	private String email;
	
	private boolean login;
	
	private User user;
	
}
