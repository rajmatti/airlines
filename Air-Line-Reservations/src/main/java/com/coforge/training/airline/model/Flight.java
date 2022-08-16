package com.coforge.training.airline.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	private long flightid;
	
	private String flightname;
	
	private String flightfrom;
	
	private String flightto;
	
	private String flightfromtime;
	
	private String flighttotime;
	
	private String flightstatus;
	
	private String flightgateno;
	
	private String flightfromdate;
	
	private String flighttodate;
	
	private String flightcompanyname;
	
	private String adminemail;
	
	private long airportid;
	
	@OneToMany(targetEntity = Seats.class, cascade = CascadeType.MERGE)
	@JoinColumn(name="FK_FS")
	private List<Seats> flightseats;
	
	
}
