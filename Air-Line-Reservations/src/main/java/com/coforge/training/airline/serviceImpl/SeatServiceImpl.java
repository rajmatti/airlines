package com.coforge.training.airline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.BookFlightSeatData;
import com.coforge.training.airline.model.Seats;
import com.coforge.training.airline.repository.SeatsRepo;
import com.coforge.training.airline.response.SeatAvailableResponse;
import com.coforge.training.airline.response.VerifySeatResponse;
import com.coforge.training.airline.response.checkSeatsReponse;
import com.coforge.training.airline.service.SeatService;

@Service
public class SeatServiceImpl implements SeatService{

	@Autowired
	private SeatsRepo repo;

	@Autowired
	private BookFlightSeatDateServiceImpl service;

	@Override
	public List<Seats> getBookFlightSeatData(long flightid, String seattype) {
		return repo.findAllByFlightidAndSeattype(flightid, seattype);
	}

	@Override
	public List<Seats> getFlightBySeats(long flightid) {
		return repo.findByFlightid(flightid);
	}

	@Override
	public String deleteById(long seatid) {
		if(repo.existsById(seatid))
		{
			repo.deleteById(seatid);
			return "Delete Seat";
		}
		return "Id is not exist";
	}

	@Override
	public SeatAvailableResponse getBookdataByFlightSeatData(long flightid, String seattype) {
		SeatAvailableResponse res=new SeatAvailableResponse();
		Seats seat=repo.findByFlightidAndSeattype(flightid, seattype);

		res.setFlightid(seat.getFlightid());
		res.setSeatid(seat.getSeatid());
		res.setSeatprize(seat.getSeatprize());
		res.setSeattype(seat.getSeattype());
		res.setTotalseats(seat.getTotalseats());
		checkSeatsReponse check=service.checkSeatAvailability(flightid,seattype);
		if(check.getAvailableseats()<=0)
		{
			res.setAvailableseat(0);
			return res;
		}
		res.setAvailableseat(check.getAvailableseats());

		return res;
	}

	@Override
	public VerifySeatResponse verify(long flightid, List<Seats> seat) {
		VerifySeatResponse res=new VerifySeatResponse();
		res.setCheck(true);
		for(Seats s:seat)
		{
			SeatAvailableResponse check=getBookdataByFlightSeatData(flightid, s.getSeattype());
			if(check.getAvailableseat()<=0)
			{
				res.setCheck(false);
				res.setMessage(check.getSeattype() +" is not available");
				return res;
			}
		}

		return res;

	}


}
