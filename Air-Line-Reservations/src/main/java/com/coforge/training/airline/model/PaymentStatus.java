package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paymentstatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentstatusid;
	
	private long userid;
	
	private long flightid;
	
	private String upiid;
	
	private double totalamount;
	
	private double paidamount;
	
	private String paymentstatus;
	
	private long bookid;
	
	private long cardno;
	
	private long recardno;
	
	private long cvv;
	
	private String cardhldername;
	
}
