package com.car.service.intf;

import com.car.pojo.Cars;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CarsServiceIntf {

	/**
	 * 添加汽车信息
	 * @param cars
	 * @return
	 */
	boolean addCar(Cars cars);

	/**
	 * 查询汽车信息（高级查询）
	 * @param cars
	 * @param pageNum
	 * @param pageSize
	 */
	PageInfo<Cars> findCars(Cars cars, int pageNum, int pageSize);

	/**
	 * 删除汽车信息
	 * @param carNumber
	 * @return 
	 */
	boolean removeCar(String carNumber);

	/**
	 * 查询汽车信息（单独查询）
	 * @param carNumber
	 * @return
	 */
	Cars selectCar(String carNumber);

	/**
	 * 修改汽车信息
	 * @param cars
	 */
	void modifyCar(Cars cars);

	/**
	 * 查询所有汽车信息
	 * @return
	 */
	List<Cars> queryCars();
}
