package com.coforge.training.airline.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.airline.model.seatType;
import com.coforge.training.airline.repository.SeatTypeRepo;
import com.coforge.training.airline.response.SeatTypeUpdateResponse;
import com.coforge.training.airline.service.SeatTypeService;

@Service
public class SeatTypeServiceImpl implements SeatTypeService{

	@Autowired
	private SeatTypeRepo repo;

	
	@Override
	public seatType saveNewSeat(seatType seat) {
		// TODO Auto-generated method stub
		return repo.save(seat);
	}


	@Override
	public List<seatType> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public seatType getByOne(long seattypeid) {
		// TODO Auto-generated method stub
		return repo.findById(seattypeid).get();
	}


	@Override
	public SeatTypeUpdateResponse update(long seattypeid, seatType seat) {
		// TODO Auto-generated method stub
		SeatTypeUpdateResponse res=new SeatTypeUpdateResponse();
		if(repo.existsById(seattypeid))
		{
			res.setSeat(repo.save(seat));
			res.setMessage("Seat Type is updated");
		}
		else {
			res.setMessage("seat is not exist");
		}
		
		return res;
	}


	@Override
	public String deleteMap(long seattypeid) {
		// TODO Auto-generated method stub
		if(repo.existsById(seattypeid))
		{
			repo.deleteById(seattypeid);
			return "Seat Type is Delete";
		}
		return "Id is not exist";
	}
	
}
