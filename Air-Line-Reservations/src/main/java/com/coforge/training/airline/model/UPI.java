package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "upi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UPI {

	@Id
	private String upiid;
	
	private int code;
	
}
