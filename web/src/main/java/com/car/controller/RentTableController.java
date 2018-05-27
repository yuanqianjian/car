package com.car.controller;

import com.car.pojo.Cars;
import com.car.pojo.RentTable;
import com.car.pojo.Users;
import com.car.service.intf.CarsServiceIntf;
import com.car.service.intf.RentTableServiceIntf;
import com.car.service.intf.UsersServiceIntf;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("prototype")
@RequestMapping("/rent")
public class RentTableController {
	@Autowired
	private RentTableServiceIntf rentservice;
	@Autowired
	private CarsServiceIntf carsservice;
	@Autowired
	private UsersServiceIntf usersService;

	@RequestMapping("/addRent.do")
	public String addRent(RentTable rentTable,Model model){
		//添加出租信息
		boolean flag = rentservice.addRent(rentTable);
		if (flag) {
			
			return "redirect:/tips.jsp";
		}
		model.addAttribute("message", "出租汽车失败");
		return "carservice/createRenting";
	}
	
	@RequestMapping("/queryTableId.do")
	public String queryTableId(Long tableId,Model model){
		//查询出租单编号信息
		RentTable rentTable = rentservice.selectRent(tableId);
		if (rentTable != null) {
			//出租单状态
			model.addAttribute("rentTable", rentTable);
			
			//车辆信息
			Cars car = carsservice.selectCar(rentTable.getCarId());
			model.addAttribute("car", car);
			//用户信息
			Users user = usersService.selectUser(rentTable.getUserId());
			model.addAttribute("user", user);
			
			//生成检查单编号
			DateFormat d1 = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			String checkId = d1.format(date);
			model.addAttribute("checkId", checkId);
			
			//生成检查单日期
			DateFormat d2 = new SimpleDateFormat("yyyy-MM-dd");
			String checkDate = d2.format(date);
			model.addAttribute("checkDate", checkDate);
			
			return "carservice/createRenturning";
		}
		model.addAttribute("message", "出租单号填写错误！！");
		return "carservice/returnCar";
	}
	
	@RequestMapping("/findRents.do")
	public String findRents(RentTable rentTable,Model model,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
		//查询出租单信息（高级查询）
		PageInfo<RentTable> pi = rentservice.findRents(rentTable,pageNum,pageSize);
		//保存总记录数
		model.addAttribute("total", pi.getTotal());
		//保存分页数据
		model.addAttribute("rentsList", pi.getList());
		//一共多少页数
		model.addAttribute("pages", pi.getPages());
		//当前是第几页
		model.addAttribute("pageNum", pi.getPageNum());
		//
		model.addAttribute("oldRent", rentTable);
		return "rentManager/showRents";
	}
	
	@RequestMapping("/SelectRent.do")
	public String selectRent(Long tableId,Model model){
		//查找出租单信息
		RentTable rentTable = rentservice.selectRent(tableId);
		model.addAttribute("rent", rentTable);
		return "rentManager/updateRent";
	}
	
	@RequestMapping("/DeleteRent.do")
	public String deleteRent(RentTable rentTable){
		//删除出租单信息
		rentservice.deleteRent(rentTable);
		
		return "redirect:/tips.jsp";
	}
	
	@RequestMapping("/ModifyRent.do")
	public String modifyRent(RentTable rentTable){
		//修改出租单信息
		rentservice.modifyRent(rentTable);
		
		return "redirect:/tips.jsp";
	}
	
	@RequestMapping("/MonthStatisticsCar.do")
	public String theCurrentMonth(Model model,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
		//查询当月应还汽车信息
		RentTable rentTable = new RentTable();
		rentTable.setRentFlag(1);
		PageInfo<RentTable> pi = rentservice.findRents(rentTable, pageNum, pageSize);
		//保存总记录数
		model.addAttribute("total", pi.getTotal());
		//保存分页数据
		model.addAttribute("rentsList", pi.getList());
		//一共多少页数
		model.addAttribute("pages", pi.getPages());
		//当前是第几页
		model.addAttribute("pageNum", pi.getPageNum());
		//
		return "carservice/theCurrentMonth";
	}
	
	@RequestMapping("/SelectRUC.do")
	public String selectRUC(Long tableId,Model model){
		//查找出租单信息
		RentTable rentTable = rentservice.selectRent(tableId);
		model.addAttribute("rentTable", rentTable);
		
		//车辆信息
		Cars car = carsservice.selectCar(rentTable.getCarId());
		model.addAttribute("car", car);
		
		//用户信息
		Users user = usersService.selectUser(rentTable.getUserId());
		model.addAttribute("user", user);
		
		return "carservice/findMonthReturnCar";
	}
}
