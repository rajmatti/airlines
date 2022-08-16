package com.coforge.training.airline.response;

import com.coforge.training.airline.model.FlightCompany;

import lombok.Data;

@Data
public class UpdateFlightCompanyResponse {

	private String message;

	private boolean check;

	private String companyname;

	private FlightCompany fCompany;

}
