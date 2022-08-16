package com.coforge.training.airline.service;

import java.util.List;

import com.coforge.training.airline.model.seatType;
import com.coforge.training.airline.response.SeatTypeUpdateResponse;

public interface SeatTypeService {

	public seatType saveNewSeat(seatType seat);

	public List<seatType> getAll();

	public seatType getByOne(long seattypeid);

	public SeatTypeUpdateResponse update(long seattypeid, seatType seat);

	public String deleteMap(long seattypeid);

}
