package com.car.mapper;

import com.car.pojo.Funs;

import java.util.List;

public interface IFunsMapper {

	/**
	 * 查询对应权限能访问的页面
	 * @param menuId 
	 * @return
	 */
	List<Funs> selectByMenuId(Integer menuId);
   
}