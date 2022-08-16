package com.coforge.training.airline.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.Flight;
import com.coforge.training.airline.model.Seats;
import com.coforge.training.airline.repository.AdminContentRepo;
import com.coforge.training.airline.repository.AirPortRepo;
import com.coforge.training.airline.repository.FlightRepo;
import com.coforge.training.airline.repository.SeatsRepo;
import com.coforge.training.airline.repository.UserRepo;
import com.coforge.training.airline.response.FlightSaveResponse;
import com.coforge.training.airline.response.GetAllFlightsByAirportCode;
import com.coforge.training.airline.service.FlightService;
import com.coforge.training.airline.random.RandomNoGenerator;

@Service
public class FlightServiceImpl implements FlightService
{
	
	@Autowired
	private FlightRepo repo;
	
	
	@Autowired
	private AdminContentRepo adminRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private SeatsRepo seatRepo;
	
	@Autowired
	private AirPortRepo airRepo;

	@Override
	public FlightSaveResponse saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		FlightSaveResponse res=new FlightSaveResponse();
		
		if(adminRepo.existsById(flight.getAdminemail()) && userRepo.existsByEmail(flight.getAdminemail()) && airRepo.existsById(flight.getAirportid()))
		{
			RandomNoGenerator rand=new RandomNoGenerator();
			
			long rendom=rand.getRamdomNumber();
			
			flight.setFlightid(rendom);
			
			List<Seats> listSeats=new ArrayList<>();
			
			listSeats.addAll(flight.getFlightseats());
			
			for(Seats seat:listSeats)
			{
				seat.setFlightid(rendom);
			}
			
			flight.setFlightseats(listSeats);
			
			res.setFligth(repo.save(flight));
			res.setEmail(flight.getAdminemail());
			res.setMessage("Flight Save");
			res.setStatus(true);
			
		}
		else
		{
			res.setMessage("Admin crenditials invalid");
		}
	
		return res;
	}

	@Override
	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Flight getOneFlight(long flightid) {
		return repo.findById(flightid).get();
	}

	@Override
	public FlightSaveResponse updateFlight(long flightid, Flight flight) {
		
		FlightSaveResponse res=new FlightSaveResponse();
		
		if(repo.existsById(flightid))
		{
			// save
			res.setFligth(repo.save(flight));
			
//			Set flight at response
			Flight fly=res.getFligth();
			List<Seats> getAllseats=seatRepo.findByFlightid(flightid);
			fly.setFlightseats(getAllseats);
			res.setFligth(fly);
			
			res.setMessage("Flight is updated");
			res.setEmail(flight.getAdminemail());
			res.setStatus(true);
		}
		else
		{
			res.setMessage("Flight is not exist");
			res.setFligth(flight);
			res.setStatus(false);
			res.setEmail(flight.getAdminemail());
		}
		return res;
	}
	
	

	@Override
	public String deleteFlight(long flightid) {
		// TODO Auto-generated method stub
		
		if(repo.existsById(flightid))
		{
			List<Seats> listSeat=seatRepo.findByFlightid(flightid);
			for(Seats seat: listSeat)
			{
				seatRepo.deleteById(seat.getSeatid());
			}
			repo.deleteById(flightid);
			return "Flight is Delete";
		}
		
		return "Flight is not exist";
	}
	
	

	@Override
	public List<Flight> getFlightByUser(String adminemail) {
		// TODO Auto-generated method stub
		List<Flight> listfly=repo.findByAdminemail(adminemail);
		
		for(Flight fly:listfly)
		{
			Flight finalflight=fly;
			List<Seats> seatRes=seatRepo.findByFlightid(fly.getFlightid());
			finalflight.setFlightseats(seatRes);
		}
		
		return listfly;
	}

	@Override
	public GetAllFlightsByAirportCode getAllFlightsByAirport(long airportcode) {
		// TODO Auto-generated method stub\
		
		GetAllFlightsByAirportCode res=new GetAllFlightsByAirportCode();
		
		if(airRepo.existsById(airportcode))
		{
			res.setAirport(airRepo.findById(airportcode).get());
			res.setFlight(repo.findAllByAirportid(airportcode));
			res.setMessage("All data available");
		}
		else
		{
			res.setMessage("This airport is not exist");
		}
		return res;
	}

}
