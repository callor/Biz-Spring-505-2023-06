package com.callor.car.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.car.model.CarDto;

public interface CarDao {
	public int insert(CarDto carDto);
	public CarDto findTachoByCarNum(String carnum);
	@Select("SELECT * FROM tbl_carmanager "
			+ " ORDER BY c_edate DESC, c_etime DESC")
	public List<CarDto> selectAll();
	
}
