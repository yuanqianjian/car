package com.car.service.impl;

import com.car.mapper.ICarsMapper;
import com.car.mapper.IRenttableMapper;
import com.car.pojo.Cars;
import com.car.pojo.RentTable;
import com.car.service.intf.CarsServiceIntf;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carsServiceIntf")
public class CarsServiceImpl implements CarsServiceIntf {

	@Autowired
	private ICarsMapper mapper;
	@Autowired
	private IRenttableMapper rMapper;
	
	@Override
	public boolean addCar(Cars cars) {
		
		return mapper.insert(cars);
	}

	@Override
	public PageInfo<Cars> findCars(Cars cars,int pageNum,int pageSize) {
		//查询分页数据
		PageHelper.startPage(pageNum, pageSize);
		List<Cars> list = mapper.selectByCars(cars);
		//将list封装成pageinfo对象
		PageInfo<Cars> pi = new PageInfo<>(list);
		return pi;
	}

	@Override
	public boolean removeCar(String carNumber) {
		//查询汽车是否被出租过
		List<RentTable> rentTable= rMapper.selectBycarId(carNumber);
		if (rentTable.size() == 0) {
			return mapper.deleteCar(carNumber);
		}
		return false;
	}

	@Override
	public Cars selectCar(String carNumber) {
		
		return mapper.toUpdateCar(carNumber);
	}

	@Override
	public void modifyCar(Cars cars) {
		
		mapper.updateCar(cars);
	}

	@Override
	public List<Cars> queryCars() {
		
		return mapper.selectCars();
	}

}
