package com.car.controller;

import com.car.pojo.CheckTable;
import com.car.service.intf.CheckTableServiceIntf;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("prototype")
@RequestMapping("/check")
public class CheckTableController {
	@Autowired
	private CheckTableServiceIntf checkservice;
	
	@RequestMapping("/addCheck.do")
	public String addCheck(CheckTable checkTable,String carNumber,Model model){
		//添加还车信息
		boolean flag = checkservice.addCheck(checkTable,carNumber);
		if (flag) {
			
			return "redirect:/tips.jsp";
		}
		model.addAttribute("message", "还车失败");
		return "carservice/createRenturning";
	}
	
	@RequestMapping("/findChecks.do")
	public String findChecks(CheckTable checkTable,Model model,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
		//查询检查单信息（高级查询）
		PageInfo<CheckTable> pi = checkservice.findChecks(checkTable, pageNum, pageSize);
		//保存总记录数
		model.addAttribute("total", pi.getTotal());
		//保存分页数据
		model.addAttribute("checksList", pi.getList());
		//一共多少页数
		model.addAttribute("pages", pi.getPages());
		//当前是第几页
		model.addAttribute("pageNum", pi.getPageNum());
		//
		model.addAttribute("oldCheck", checkTable);
		return "checkManager/showReturn";
	}
	
	@RequestMapping("/SelectCheck.do")
	public String selectCheck(Long checkId,Model model){
		//查找检查单信息
		CheckTable checkTable = checkservice.selectCheck(checkId);
		model.addAttribute("check", checkTable);
		return "checkManager/updateReturn";
	}
	
	@RequestMapping("/DeleteCheck.do")
	public String deleteCheck(Long checkId){
		//删除检查单信息
		checkservice.deleteReturn(checkId);
		
		return "redirect:/tips.jsp";
	}
	
	@RequestMapping("/ModifyReturn.do")
	public String modifyReturn(CheckTable checkTable){
		//修改检查单信息
		checkservice.modifyReturn(checkTable);
		
		return "redirect:/tips.jsp";
	}
	
}
