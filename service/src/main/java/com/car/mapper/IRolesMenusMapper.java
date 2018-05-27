package com.car.mapper;

import com.car.pojo.RolesMenusKey;

import java.util.List;

public interface IRolesMenusMapper {
    
	/**
	 * 添加角色权限
	 * @param rolesMenusKey
	 * @return
	 */
    int insert(RolesMenusKey rolesMenusKey);

	/**
	 * 查询角色权限信息
	 * @param roleId
	 * @return
	 */
    List<RolesMenusKey> selectByRoleId(Integer roleId);

    /**
     * 移除该角色所有权限
     * @param roleId
     */
	void removeRoleMenu(Integer roleId);

}