package com.coforge.training.airline.response;

import lombok.Data;

@Data
public class VerifySeatResponse {

	private boolean check;
	
	private String message;
	
}
