package com.city.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.city.oa.model.EmployeeModel;

//系统主页控制器
@Controller
@RequestMapping(value="/home")

public class HomeController {
	@RequestMapping(value="tomain")
	public String tomain(@SessionAttribute(required=false) EmployeeModel user) throws Exception{
		if(user!=null) {
			System.out.println(user.getId());
		}
		return "home/main";
	}
}
