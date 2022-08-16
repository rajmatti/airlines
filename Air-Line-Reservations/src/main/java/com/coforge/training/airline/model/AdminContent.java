package com.coforge.training.airline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alladmin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminContent {

	@Id
	private String adminemail;
	
}
