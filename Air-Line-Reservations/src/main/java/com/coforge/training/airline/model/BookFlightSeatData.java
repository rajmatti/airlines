package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coforge.training.airline.enums.GenderEnums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookflightseatdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookFlightSeatData 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookflightseatid;
	
	private long userid;
	
	private String name;
	
	private String email;
	
	private String phoneno;
	
	private String passportno;
	
	private String country;
	
	private long bookid;
	
	@Enumerated(value = EnumType.STRING)
	private GenderEnums gender;
	
	private int seatno;
	
	private String seattype;
	
	private long flightid;
	
	private double price;
	
	
}
