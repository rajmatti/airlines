package com.coforge.training.airline.response;

import com.coforge.training.airline.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {

	private String message;
	
	private boolean check;
	
	private String email;
	
	private User user;
	
	
}
