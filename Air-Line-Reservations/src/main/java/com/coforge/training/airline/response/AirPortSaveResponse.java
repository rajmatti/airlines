package com.coforge.training.airline.response;

import com.coforge.training.airline.model.AirPort;

import lombok.Data;

@Data
public class AirPortSaveResponse {

	private String message;
	
	private AirPort airport;
	
}
