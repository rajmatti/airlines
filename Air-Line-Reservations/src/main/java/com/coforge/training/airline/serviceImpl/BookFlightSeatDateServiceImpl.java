package com.coforge.training.airline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.BookFlightSeatData;
import com.coforge.training.airline.model.Seats;
import com.coforge.training.airline.repository.BookFlightSeatDataRepo;
import com.coforge.training.airline.repository.SeatsRepo;
import com.coforge.training.airline.response.BookFlightSeatDataAllListResponse;
import com.coforge.training.airline.response.SeatAvailabilityListResponse;
import com.coforge.training.airline.response.checkSeatsReponse;
import com.coforge.training.airline.service.BookFlightSeatDataService;


@Service
public class BookFlightSeatDateServiceImpl implements BookFlightSeatDataService{

	@Autowired
	private BookFlightSeatDataRepo repo;
	
	@Autowired
	private SeatsRepo seatsRepo;
	
	@Override
	public BookFlightSeatData getById(long bookflightseatid) {
		return repo.findById(bookflightseatid).get();
	}

	@Override
	public BookFlightSeatDataAllListResponse getAllSeatsByFlight(long flightid) {

		BookFlightSeatDataAllListResponse res=new BookFlightSeatDataAllListResponse();
		
		if(repo.existsByFlightid(flightid))
		{
			res.setSeats(repo.findAllByFlightid(flightid));
			res.setCheck(true);
			res.setTotalseats(res.getSeats().size());
			res.setMessage("It Exist");
		}
		else
		{
			res.setCheck(false);
			res.setMessage("Not available");
			res.setTotalseats(0);
			res.setSeats(null);
		}

		return res;
	}

	@Override
	public SeatAvailabilityListResponse checkAllAvailability(long flightid) {
		
		SeatAvailabilityListResponse res=new SeatAvailabilityListResponse();
		
		List<Seats> bookSeat=seatsRepo.findAllByFlightid(flightid);
		if(bookSeat!=null)
		{
			res.setSeats(bookSeat);
			res.setFlightid(flightid);
			res.setCheck(true);
			res.setMessage("Hear All Seat By Fligth Id");
		}
		else
		{
			res.setMessage("This Flight is not exist");
			res.setCheck(false);
			
		}
		return res;
	}

	
	public checkSeatsReponse checkSeatAvailability(long flightid, String seatType)
	{
		checkSeatsReponse res=new checkSeatsReponse();
		
		Seats totalSeat=seatsRepo.findByFlightidAndSeattype(flightid,seatType);
		
		List<BookFlightSeatData> bookTickets=repo.findAllByFlightid(flightid);
		
		int s=1;
		for(BookFlightSeatData seat:bookTickets)
		{
			if(seat.getSeattype().equals(seatType))
			{
				s++;
			}
		}
		
		res.setTotalnoofseats(totalSeat.getTotalseats());
		res.setBookseats(s);
		res.setAvailableseats(totalSeat.getTotalseats()-bookTickets.size());
		
		return res;
	}

	@Override
	public List<BookFlightSeatData> getBookFlightSeatData(long flightid, String seattype) {
		return repo.findByFlightidAndSeattype(flightid,seattype);
	}

}
