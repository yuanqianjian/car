package com.car.mapper;

import com.car.pojo.Cars;

import java.util.List;

public interface ICarsMapper {

	/**
	 * 添加汽车信息
	 * @param cars
	 * @return
	 */
	boolean insert(Cars cars);

	/**
	 * 查询汽车信息条数（数量Size）
	 * @param cars
	 * @return
	 */
	int selectSize(Cars cars);

	/**
	 * 查询汽车信息（高级查询）
	 * @param cars
	 * @return
	 */
	List<Cars> selectByCars(Cars cars);

	/**
	 * 删除汽车信息
	 * @param carNumber
	 * @return 
	 */
	boolean deleteCar(String carNumber);

	/**
	 * 查询汽车信息（单独查询）
	 * @param carNumber
	 * @return
	 */
	Cars toUpdateCar(String carNumber);

	/**
	 * 修改汽车信息
	 * @param cars
	 */
	void updateCar(Cars cars);

	/**
	 * 查询所有汽车信息
	 * @return
	 */
	List<Cars> selectCars();
}