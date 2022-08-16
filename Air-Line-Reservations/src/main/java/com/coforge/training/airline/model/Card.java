package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

	@Id
	private long cardno;
	
	private long recardno;
	
	private int cvv;
	
	private String name;
	
	private int code;
	
}
