package com.callor.car.service;

import java.util.List;

import com.callor.car.model.CarDto;

public interface CarService {

	public CarDto findTachoByCarNum(String carnum);
	public int insert(CarDto carDto);
	public List<CarDto> selectAll();

}
