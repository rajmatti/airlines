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
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressid;
	
	private int userhouseno;
	
	private String userStreet;
	
	private String usercity;
	
	private String userstate;
	
	private String usercountry;
	
	private int userpincode;
	
	private long userid;
	
}
