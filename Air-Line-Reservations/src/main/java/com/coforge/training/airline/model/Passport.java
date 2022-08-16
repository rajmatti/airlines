package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passport")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport 
{
	@Id
	private String passportno;
	
	private String issuedate;
	
	private String expiredate;
	
	private long userid;
	
}
