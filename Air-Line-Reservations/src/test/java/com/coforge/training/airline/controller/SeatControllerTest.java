package com.coforge.training.airline.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;


import com.coforge.training.airline.model.Seats;

import com.coforge.training.airline.repository.SeatsRepo;

import com.coforge.training.airline.service.SeatService;

class SeatControllerTest {
	
	@Mock
	private SeatService service;

	@Mock
	private SeatsRepo repo;


	@Spy
	private Model model;

	@Spy
	List<Seats> seat = new ArrayList<Seats>();

	@Spy
	HttpServletRequest req;

	@Spy
	HttpSession ses;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		seat=getSeatsList();
	}


	private List<Seats> getSeatsList() {
		Seats s1 = new Seats();
		s1.setFlightid(2L);
		s1.setSeatid(1L);
		s1.setSeatprize(2400.00);
		s1.setSeattype("ECONOMY");
		s1.setTotalseats(13);
		List<Seats> res = new ArrayList<Seats>();
		res.add(s1);
		return res;
	}


	@Test
	void testGetBookFlightByFlightIdAndSeattype() {
		Seats res=new Seats();
		res.setFlightid(seat.get(0).getFlightid());
		res.setSeattype(seat.get(0).getSeattype());
		
		List<Seats> b1 =new ArrayList<Seats>();
		b1.add(res);
		when(service.getBookFlightSeatData(seat.get(0).getFlightid(),seat.get(0).getSeattype())).thenReturn(b1);
		
		List<Seats> x=   service.getBookFlightSeatData(seat.get(0).getFlightid(),seat.get(0).getSeattype());
		
		assertNotNull(res);
		assertEquals(b1,x);
		
	  verify(service,times(1)).getBookFlightSeatData(seat.get(0).getFlightid(),seat.get(0).getSeattype());
	}

	@Test
	void testGetFlightBySeats() {
		Seats res=new Seats();
		//BookFlightSeatData a= bTicket.get(0);
		res.setSeatid(seat.get(0).getSeatid());
		// seat=sType.get(0);
		List<Seats> s = new ArrayList<Seats>();
		s.add(res);
		
		
		when(service.getFlightBySeats(seat.get(0).getSeatid())).thenReturn(s);
		
	List<Seats> b=service.getFlightBySeats(seat.get(0).getSeatid());
		assertNotNull(res);
		
		assertEquals(s,b);
		verify(service,times(1)).getFlightBySeats(seat.get(0).getSeatid());

	}

	@Test
	void testDeleteSeatById() {
		String del = "Seat is deleted";
		when(service.deleteById(seat.get(0).getSeatid())).thenReturn(del);// if id is present the return del
		String str=service.deleteById(seat.get(0).getSeatid());
		assertNotNull(str); //a passed parameter must not be null if it ia null then test case fails
	//	String s="";
		assertEquals(del, str);
		verify(service,times(1)).deleteById(seat.get(0).getSeatid());
	}

}
