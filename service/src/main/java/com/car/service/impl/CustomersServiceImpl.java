package com.car.service.impl;

import com.car.mapper.ICustomersMapper;
import com.car.mapper.IRenttableMapper;
import com.car.pojo.Customers;
import com.car.pojo.RentTable;
import com.car.service.intf.CustomersServiceIntf;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customersServiceIntf")
public class CustomersServiceImpl implements CustomersServiceIntf {

	@Autowired
	private ICustomersMapper mapper;
	@Autowired
	private IRenttableMapper rMapper;

	@Override
	public boolean addCustomer(Customers customers) {
		
		return mapper.insert(customers);
	}

	@Override
	public PageInfo<Customers> findCustomers(Customers customers,int pageNum,int pageSize) {
		//查询分页数据
		PageHelper.startPage(pageNum, pageSize);
		List<Customers> list = mapper.selectByCustomers(customers);
		//将list封装成pageinfo对象
		PageInfo<Customers> pi = new PageInfo<>(list);
		return pi;
	}

	@Override
	public boolean removeCustomer(String identity) {
		//查询出租单中是否有出租记录
		List<RentTable> rentTable = rMapper.selectByCustId(identity);
		if (rentTable.size() == 0) {
			return mapper.deleteCustomer(identity);
		}
		return false;
	}

	@Override
	public Customers selectCustomer(String identity) {
		
		return mapper.toUpdateCustomer(identity);
	}

	@Override
	public void modifyCustomer(Customers customers) {
		
		mapper.updateCustomer(customers);
	}

	@Override
	public Customers queryCustomer(String identity) {
		
		return mapper.selectByIdentity(identity);
	}
}
