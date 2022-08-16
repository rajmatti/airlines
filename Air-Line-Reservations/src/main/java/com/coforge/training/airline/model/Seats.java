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
@Table(name = "seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seats {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seatid;
	
	private String seattype;
	
	private int totalseats;
	
	private double seatprize;
	
	private long flightid;
	
}
