package com.car.service.impl;

import com.car.mapper.ICarsMapper;
import com.car.mapper.IChecktableMapper;
import com.car.mapper.IRenttableMapper;
import com.car.pojo.Cars;
import com.car.pojo.CheckTable;
import com.car.pojo.RentTable;
import com.car.service.intf.CheckTableServiceIntf;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("checkTableServiceIntf")
public class CheckTableServiceImpl implements CheckTableServiceIntf {

	@Autowired
	private IChecktableMapper mapper;
	@Autowired
	private IRenttableMapper rentMapper;
	@Autowired
	private ICarsMapper carMapper;
	
	@Override
	public boolean addCheck(CheckTable checkTable,String carNumber) {
		boolean flag = mapper.insert(checkTable);
		if (flag) {
			//修改出租单的出租状态
			RentTable rentTable = new RentTable(checkTable.getRentId(), -1.0, -1.0, -1.0, null, null, checkTable.getCheckDate(), 0, null, null, null);
			rentMapper.updateRent(rentTable);
			
			//修改汽车的出租状态
			Cars cars = new Cars(carNumber, null, null, null, null, null, "未出租", null, null);
			carMapper.updateCar(cars);
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<CheckTable> findChecks(CheckTable checkTable,int pageNum,int pageSize) {
		//查询分页数据
		PageHelper.startPage(pageNum, pageSize);
		List<CheckTable> list = mapper.selectByChecks(checkTable);
		//将list封装成pageinfo对象
		PageInfo<CheckTable> pi = new PageInfo<>(list);
		return pi;
	}

	@Override
	public CheckTable selectCheck(Long checkId) {
		
		return mapper.selectCheckByCheckId(checkId);
	}

	@Override
	public void deleteReturn(Long checkId) {
		
		mapper.delectCheckByCheckId(checkId);
	}

	@Override
	public void modifyReturn(CheckTable checkTable) {
		
		mapper.updateReturn(checkTable);
	}

}
