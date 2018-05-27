package com.car.service.impl;

import com.car.mapper.IChecktableMapper;
import com.car.mapper.IRenttableMapper;
import com.car.mapper.IUsersMapper;
import com.car.pojo.CheckTable;
import com.car.pojo.RentTable;
import com.car.pojo.Users;
import com.car.service.intf.UsersServiceIntf;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersServiceIntf")
public class UsersServiceImpl implements UsersServiceIntf {

	@Autowired
	private IUsersMapper mapper;
	@Autowired
	private IRenttableMapper rMapper;
	@Autowired
	private IChecktableMapper checkMapper;
	
	@Override
	public boolean addUser(Users users) {
		
		return mapper.insert(users);
	}

	@Override
	public PageInfo<Users> findUsers(Users user, int pageNum, int pageSize) {
		//查询分页数据
		PageHelper.startPage(pageNum, pageSize);
		List<Users> list = mapper.selectByUsers(user);
		//将list封装成pageinfo对象
		PageInfo<Users> pi = new PageInfo<>(list);
		return pi;
	}

	@Override
	public boolean removeUser(String userName) {
		//查询出租单中是否有出租记录
		List<RentTable> rentTable = rMapper.selectByUserId(userName);
		List<CheckTable> checkTable = checkMapper.selectByUserId(userName);
		if (rentTable.size() == 0 && checkTable.size() == 0) {
			return mapper.deleteUser(userName);
		}
		return false;
	}

	@Override
	public Users selectUser(String userName) {
		
		return mapper.toUpdateUser(userName);
	}

	@Override
	public boolean modifyUser(Users user) {
		
		return mapper.updateUser(user);
	}

	@Override
	public Users login(Users users) {
		
		return mapper.selectByPassword(users);
	}

	@Override
	public Users selectByIdentity(String identity) {
		
		return mapper.selectByIdentity(identity);
	}

}
