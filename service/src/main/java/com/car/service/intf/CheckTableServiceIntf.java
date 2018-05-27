package com.car.service.intf;

import com.car.pojo.CheckTable;
import com.github.pagehelper.PageInfo;

public interface CheckTableServiceIntf {

	/**
	 * 添加检查单信息
	 * @param checkTable
	 * @return
	 */
	boolean addCheck(CheckTable checkTable, String carNumber);

	/**
	 * 查询检查单信息（高级查询）（分页）
	 * @param pageNum
	 * @param pageSize
	 * @param checkTable
	 */
	PageInfo<CheckTable> findChecks(CheckTable checkTable, int pageNum, int pageSize);

	/**
	 * 查询检查单信息（单独查询）
	 * @param checkId
	 * @return
	 */
	CheckTable selectCheck(Long checkId);

	/**
	 * 删除检查单信息
	 * @param checkId
	 */
	void deleteReturn(Long checkId);

	/**
	 * 修改检查单信息
	 * @param checkTable
	 */
	void modifyReturn(CheckTable checkTable);

}
