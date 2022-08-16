package com.coforge.training.airline.response;

import lombok.Data;

@Data
public class checkSeatsReponse {

	private int totalnoofseats;
	
	private int availableseats;
	
	private int bookseats;
	
}
