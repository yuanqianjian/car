package com.car.mapper;

import com.car.pojo.Users;

import java.util.List;

public interface IUsersMapper {

	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
    boolean insert(Users user);

    /**
     * 查询用户信息（高级查询）
     * @param users
     * @return
     */
	List<Users> selectByUsers(Users users);

	/**
	 * 查询用户信息条数（数量Size）
	 * @param users
	 * @return
	 */
	int selectSize(Users users);

	/**
	 *删除该用户
	 * @param userName 
	 * @return 
	 */
	boolean deleteUser(String userName);

	/**
	 * 预更新用户信息
	 * @param userName
	 * @return
	 */
	Users toUpdateUser(String userName);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	boolean updateUser(Users user);

	/**
	 * 验证用户登录信息
	 * @param users
	 * @return
	 */
	Users selectByPassword(Users users);

	/**
	 * 添加用户时验证用户身份证是否重复
	 * @param identity
	 * @return
	 */
	Users selectByIdentity(String identity);
}