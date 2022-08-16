package com.coforge.training.airline.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.coforge.training.airline.enums.GenderEnums;
import com.coforge.training.airline.enums.rolesEnums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;
	
	private String firstname;
	
	private String lastname;
	
	private String mobileno;
	
	private String dob;
	
	private String email;
	
	@Enumerated(value = EnumType.STRING)
	private GenderEnums gender;
	
	@Enumerated(value = EnumType.STRING)
	private rolesEnums role;
	
	@Column(length = 100000)
	private String avatar;
	
	private boolean completeprofile;
	
	private Date joindate;
	
	private String password;

	@OneToOne(targetEntity = Address.class,cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(targetEntity = Passport.class,cascade = CascadeType.ALL)
	private Passport passport;
	
}
