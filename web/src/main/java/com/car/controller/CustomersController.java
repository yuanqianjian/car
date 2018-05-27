package com.car.controller;

import com.car.pojo.Customers;
import com.car.service.intf.CustomersServiceIntf;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("prototype")
@RequestMapping("/customer")
public class CustomersController {
	@Autowired
	private CustomersServiceIntf customerservice;
	
	@RequestMapping("/findIdentity.do")
	@ResponseBody
	public Object findIdentity(String identity){
		//添加用户时验证登录名是否重复
		if (identity == null || identity == "") {
			return true;
		}
		Customers customer = customerservice.selectCustomer(identity);
		if (customer != null) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("/addCustomer.do")
	public String addCustomer(Customers customers){
		//添加客户信息
		customerservice.addCustomer(customers);
			
		return "redirect:/tips.jsp";
	}
	
	@RequestMapping("/findCustomers.do")
	public String findCustomers(Customers customers,Model model,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
		//查询客户信息（高级查询）（分页）
		PageInfo<Customers> pi = customerservice.findCustomers(customers, pageNum, pageSize);
		//保存总记录数
		model.addAttribute("total", pi.getTotal());
		//保存分页数据
		model.addAttribute("customersList", pi.getList());
		//一共多少页数
		model.addAttribute("pages", pi.getPages());
		//当前是第几页
		model.addAttribute("pageNum", pi.getPageNum());
		//
		model.addAttribute("oldCust", customers);
		return "customers/showCustomers";
	}
	
	@RequestMapping("/DeleteCustomer.do")
	public String DeleteCustomer(String identity,Model model){
		//删除客户信息
		boolean flag = customerservice.removeCustomer(identity);
		if (flag) {
			return "redirect:findCustomers.do";
		}
		model.addAttribute("message", "客户正在出租汽车或者保存出租资料，因不能删除");
		return "error";
	}
	
	@RequestMapping("/SelectCustomer.do")
	public String selectCustomer(String identity,Model model){
		//查询客户信息
		Customers customer = customerservice.selectCustomer(identity);
		model.addAttribute("Customer", customer);
		return "customers/updateCustomer";
	}
	
	@RequestMapping("/ModifyCustomer.do")
	public String modifyCustomer(Customers customers){
		//修改客户信息
		customerservice.modifyCustomer(customers);
		return "redirect:/tips.jsp";
	}
	
	@RequestMapping("/queryCustomer.do")
	public String queryCustomer(String identity,Model model){
		//验证客户信息
		Customers customers = customerservice.queryCustomer(identity);
		if (customers != null) {
			//生成出租单编号
			DateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			String tableId = d.format(date);
			model.addAttribute("tableId", tableId);
			
			model.addAttribute("customer", customers);
			return "carservice/createRenting";
		}
		model.addAttribute("message", "客户身份证编号填写错误！！");
		return "carservice/rentCar";
	}
	
}
