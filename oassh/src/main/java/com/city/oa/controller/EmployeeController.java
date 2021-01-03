package com.city.oa.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.city.oa.model.BehaveModel;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IBehaveService;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService=null;
	@Autowired
	private IDepartmentService departmentService=null;
	@Autowired
	private IBehaveService behaveService=null;
	
	//员工主页前分发
	@RequestMapping(value="/tomain")
	public String tomain(Model model) throws Exception{
		List<EmployeeModel> list=employeeService.getListByAll();
		model.addAttribute("emplist", list);
		return "employee/main";
	}
	//员工增加前分发
	@RequestMapping(value="/toadd")
	public String toadd(Model model) throws Exception{
		List<DepartmentModel> departmentList=departmentService.getListByAll();
		List<BehaveModel> behaveList=behaveService.getListByAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("behaveList", behaveList);
		return "employee/add";
	}
	
	
	//增加员工后处理
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(EmployeeModel em, @RequestParam MultipartFile employeePhoto) throws Exception{
		if(employeePhoto!=null&&(!employeePhoto.isEmpty())) {
			em.setPhotoContentType(employeePhoto.getContentType());
			em.setPhotoFileName("photo"+em.getId()+ employeePhoto.getOriginalFilename().substring(employeePhoto.getOriginalFilename().lastIndexOf(".")));
			em.setPhoto(employeePhoto.getBytes());
			//
			
			//File file=new File("e:/upload/"+employeePhoto.getOriginalFilename());
			//employeePhoto.transferTo(file);
			
			
		}
		employeeService.add(em);
		
		return "redirect:/employee/tomain.mvc";
	}
		
	
}
