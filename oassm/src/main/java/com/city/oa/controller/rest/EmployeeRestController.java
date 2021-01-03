package com.city.oa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.city.oa.model.EmployeeModel;
import com.city.oa.result.ExceptionResult;
import com.city.oa.service.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService employeeService=null;
	/*
	@ExceptionHandler
	public ExceptionResult controllerExceptionHander(Exception ex) throws Exception{
		System.out.println("Controller级别异常处理");
		ExceptionResult result=new ExceptionResult();
		result.setMessage(ex.getLocalizedMessage());
		return result;
	}
	*/
	@RequestMapping("/list/all")
	public List<EmployeeModel> getListByAll() throws Exception{
		return employeeService.getListByAll();
	}
}
