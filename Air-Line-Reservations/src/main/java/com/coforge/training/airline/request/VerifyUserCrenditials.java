package com.coforge.training.airline.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyUserCrenditials {

	private String email;
	
	private String phoneno;
	
}
