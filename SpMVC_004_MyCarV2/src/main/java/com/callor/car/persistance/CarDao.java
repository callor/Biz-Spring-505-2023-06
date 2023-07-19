package com.callor.car.persistance;

import com.callor.car.model.CarDto;

public interface CarDao {
	public int insert(CarDto carDto);
	public CarDto findTachoByCarNum(String carnum);
	
}
