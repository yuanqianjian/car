package com.car.controller;

import com.car.pojo.Cars;
import com.car.service.intf.CarsServiceIntf;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/car")
public class CarsController {
	@Autowired
	private CarsServiceIntf carsservice;
	
	@RequestMapping("/findCarNumber.do")
	@ResponseBody
	public Object findCarNumber(String carNumber){
		//添加汽车时验证车号是否重复
		if (carNumber == null || carNumber == "") {
			return true;
		}
		Cars car = carsservice.selectCar(carNumber);
		if (car != null) {
			return false;
		}
		return true;
	}
	
	@RequestMapping("/addCar.do")
	public String addCar(Cars cars,MultipartFile img) throws IllegalStateException, IOException{
		//添加汽车信息
		Cars car = upImage(cars, img);
		carsservice.addCar(car);
		
		return "redirect:/tips.jsp";
	}

	@RequestMapping("/ModifyCar.do")
	public String ModifyCar(Cars cars,MultipartFile img) throws IllegalStateException, IOException{
		//修改车辆信息
		Cars car = upImage(cars, img);
		carsservice.modifyCar(car);

		return "redirect:/tips.jsp";
	}

	public Cars upImage(Cars cars,MultipartFile img) throws IllegalStateException, IOException {
		// 汽车图片上传
		String path = "F:\\IDEAWorkspace\\car_Maven\\web\\src\\main\\webapp\\carImg";
		File dirFile = new File(path);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		if (img.getSize() > 0 && ("image/jpeg".equals(img.getContentType()) || "image/png".equals(img.getContentType()) || "image/gif".equals(img.getContentType()))) {
			String carImg = img.getOriginalFilename();
			//文件上传
			File File = new File(dirFile, carImg);
			img.transferTo(File);
			cars.setCarImg(carImg);
		}
		return cars;
	}
	
	@RequestMapping("/findCar.do")
	public String findCars(Cars cars, Model model,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize){
		//查询汽车信息（高级查询）（分页）
		PageInfo<Cars> pi = carsservice.findCars(cars, pageNum, pageSize);
		//保存总记录数
		model.addAttribute("total", pi.getTotal());
		//保存分页数据
		model.addAttribute("carList", pi.getList());
		//一共多少页数
		model.addAttribute("pages", pi.getPages());
		//当前是第几页
		model.addAttribute("pageNum", pi.getPageNum());
		//
		model.addAttribute("oldCar", cars);
		return "cars/showCars";
	}
	
	@RequestMapping("/DeleteCar.do")
	public String DeleteCar(String carNumber,Model model){
		//删除车辆信息
		boolean flag = carsservice.removeCar(carNumber);
		if (flag) {
			return "redirect:findCar.do";
		}
		model.addAttribute("message", "汽车出租中或者汽车被出租过要保存记录，因不能删除");
		return "error";
	}
	
	@RequestMapping(value="/SelectCar.do", produces="text/html;charset=utf-8")
	public String SelectCar(String carNumber,Model model) throws UnsupportedEncodingException{
		//查询车辆信息
		//carNumber = new String(carNumber.getBytes("iso-8859-1"), "utf-8");
		Cars car = carsservice.selectCar(carNumber);
		model.addAttribute("car", car);
		return "cars/updateCar";
	}
	
	@RequestMapping("/queryCars.do")
	@ResponseBody
	public Object queryCar(){
		//查询所有汽车信息（ajax）
		List<Cars> list = carsservice.queryCars();
		return list;
	}
}
