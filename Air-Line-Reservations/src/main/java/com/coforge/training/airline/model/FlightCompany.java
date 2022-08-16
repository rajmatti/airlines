package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flightcompany")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightCompany 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long companyid;
	
	private String companyname;
	
	private String country;
	
	private String code;
	
}
