package com.car.service.intf;

import com.car.pojo.RentTable;
import com.github.pagehelper.PageInfo;

public interface RentTableServiceIntf {

	/**
	 * 添加出租汽车信息
	 * @param rentTable
	 * @return 
	 */
	boolean addRent(RentTable rentTable);

	/**
	 * 修改出租单信息
	 * @param rentTable
	 */
	void modifyRent(RentTable rentTable);

	/**
	 * 查询出租单信息（高级查询）
	 * @param pageNum
	 * @param pageSize
	 * @param rentTable
	 */
	PageInfo<RentTable> findRents(RentTable rentTable, int pageNum, int pageSize);

	/**
	 * 查询出租单信息（单独查询）
	 * @param tableId
	 * @return
	 */
	RentTable selectRent(Long tableId);

	/**
	 * 删除出租单信息
	 * @param rentTable
	 */
	void deleteRent(RentTable rentTable);

}
