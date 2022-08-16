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


import com.coforge.training.airline.model.Flight;


import com.coforge.training.airline.repository.FlightRepo;

import com.coforge.training.airline.response.FlightSaveResponse;

import com.coforge.training.airline.service.FlightService;

class FlightControllerTest {

	@Mock
	private FlightService service;

	@Mock
	private FlightRepo repo;


	@Spy
	private Model model;

	@Spy
	List<Flight> flight = new ArrayList<Flight>();

	@Spy
	HttpServletRequest req;

	@Spy
	HttpSession ses;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		flight=getFlightList();
	}

	private List<Flight> getFlightList() {
		Flight f = new Flight();
		f.setAdminemail("a@gmail.com");
		f.setAirportid(12);
		f.setFlightcompanyname("Airway");
		f.setFlightfrom("Delhi");
		f.setFlightfromdate("12-sept-2021");
		f.setFlightfromtime("12:30 AM");
		f.setFlightgateno("23A");
		f.setFlightid(231L);
		f.setFlightname("Ranger");
		//f.setFlightseats(flight);
		f.setFlightstatus("Departure");
		f.setFlightto("Mumbai");
		f.setFlighttodate("12-09-2021");
		f.setFlighttotime("3:30 PM");

		List<Flight> res= new ArrayList<Flight>();
		res.add(f);
		return res;
	}

	@Test
	void testSaveFlight() {
		Flight add= new Flight();
		add.setAdminemail(flight.get(0).getAdminemail());
		add.setAirportid(flight.get(0).getFlightid());
		add.setFlightcompanyname(flight.get(0).getFlightcompanyname());
		add.setFlightfrom(flight.get(0).getFlightfrom());
		add.setFlightfromdate(flight.get(0).getFlightfromdate());
		add.setFlightfromtime(flight.get(0).getFlightfromtime());
		add.setFlightgateno(flight.get(0).getFlightgateno());

		FlightSaveResponse f1= new FlightSaveResponse();
		f1.setEmail("a@gmail.com");
		//f1.setFligth(add);
		f1.setMessage("FLight Is Save");
		f1.setStatus(true);

		when(service.saveFlight(flight.get(0))).thenReturn(f1);

		FlightSaveResponse res=service.saveFlight(flight.get(0));

		//assertEquals(res.getMessage(),f1.getMessage());
		assertEquals(res.getEmail(),f1.getEmail());
		//	assertNotNull(res);

		verify(service,times(1)).saveFlight(flight.get(0));
	}

	@Test
	void testGetAllFlight() {
		List<Flight> res=flight;

		when(service.getAllFlight()).thenReturn(res);

		res=service.getAllFlight();

		assertNotNull(res);

		verify(service,times(1)).getAllFlight();
	}

	@Test
	void testGetOneById() {
		Flight res=new Flight();
		res.setFlightid(flight.get(0).getFlightid());


		when(service.getOneFlight(flight.get(0).getFlightid())).thenReturn(res);


		Flight addc=service.getOneFlight(flight.get(0).getFlightid());
		//FlightCompany addc=service.getCompanyById(fCompany.get(0).get);

		assertNotNull(addc.getFlightid());
		assertEquals(res.getFlightid(), addc.getFlightid());

		verify(service,times(1)).getOneFlight(flight.get(0).getFlightid());	
	}

	@Test
	void testUpdateFlight() {
		long id=flight.get(0).getFlightid();;
		Flight f1 =flight.get(0);
		FlightSaveResponse response=new FlightSaveResponse();
		response.setMessage("Flight Type is updated");
		response.setFligth(f1);
		when(service.updateFlight(id, f1)).thenReturn(response);

		FlightSaveResponse res=service.updateFlight(id, f1);

		assertNotNull(res);
		assertEquals(res.getMessage(),"Flight Type is updated");
		assertNotNull(res.getFligth());
		assertEquals(res.getFligth(),f1 );

		verify(service,times(1)).updateFlight(id, f1);

	}

	@Test
	void testDeleteFlight() {
		String del = "Flight is deleted";
		when(service.deleteFlight(flight.get(0).getFlightid())).thenReturn(del);// if id is present the return del
		String str=service.deleteFlight(flight.get(0).getFlightid());
		assertNotNull(str); //a passed parameter must not be null if it ia null then test case fails
		verify(service,times(1)).deleteFlight(flight.get(0).getFlightid());
	}

	@Test
	void testGetFlightByAllUsers() {
		Flight res=new Flight();
		res.setAdminemail(flight.get(0).getAdminemail());

		List<Flight> f= new ArrayList<Flight>();
		f.add(res);

		when(service.getFlightByUser(flight.get(0).getAdminemail())).thenReturn(f);


		List<Flight> addc=service.getFlightByUser(flight.get(0).getAdminemail());


		assertNotNull(addc.get(0).getAdminemail());
		assertEquals(res.getAdminemail(), addc.get(0).getAdminemail());

		verify(service,times(1)).getFlightByUser(flight.get(0).getAdminemail());	
	}



}
