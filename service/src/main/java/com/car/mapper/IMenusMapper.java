package com.car.mapper;

import com.car.pojo.Menus;

import java.util.List;

public interface IMenusMapper {

	/**
	 * 根据主键查询菜单
	 * @param roleId
	 * @return
	 */
	Menus selectByMenuId(Integer roleId);
	
	/**
	 * 查询所有菜单信息(不含一级菜单)
	 * @return
	 */
	List<Menus> selectAll();
}