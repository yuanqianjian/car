package com.car.service.impl;

import com.car.mapper.ICarsMapper;
import com.car.mapper.IChecktableMapper;
import com.car.mapper.IRenttableMapper;
import com.car.pojo.Cars;
import com.car.pojo.RentTable;
import com.car.service.intf.RentTableServiceIntf;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rentTableServiceIntf")
public class RentTableServiceImpl implements RentTableServiceIntf {

	@Autowired
	private IRenttableMapper mapper;
	@Autowired
	private ICarsMapper carMapper;
	@Autowired
	private IChecktableMapper checkMapper;
	
	@Override
	public boolean addRent(RentTable rentTable) {
		boolean flag = mapper.insert(rentTable);
		if (flag) {
			//修改汽车信息的出租状态
			Cars cars = new Cars(rentTable.getCarId(), null, null, null, null, null, "已出租", null, null);
			carMapper.updateCar(cars);
			return true;
		}
		return false;
	}

	@Override
	public void modifyRent(RentTable rentTable) {
		
		mapper.updateRent(rentTable);
	}

	@Override
	public PageInfo<RentTable> findRents(RentTable rentTable,int pageNum,int pageSize) {
		//查询分页数据
		PageHelper.startPage(pageNum, pageSize);
		List<RentTable> list = mapper.selectByRents(rentTable);
		//将list封装成pageinfo对象
		PageInfo<RentTable> pi = new PageInfo<>(list);
		return pi;
	}

	@Override
	public RentTable selectRent(Long tableId) {
		
		return mapper.selectByTableId(tableId);
	}

	@Override
	public void deleteRent(RentTable rentTable) {
		if (rentTable.getRentFlag() == 1) {
			//修改汽车信息的出租状态
			Cars cars = new Cars(rentTable.getCarId(), null, null, null, null, null, "未出租", null, null);
			carMapper.updateCar(cars);
		}
		checkMapper.delectCheckByTableId(rentTable.getTableId());
		mapper.deleteRent(rentTable.getTableId());
	}

}
