package com.city.oa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.city.oa.model.EmployeeModel;

@Controller
@RequestMapping(value="/user")
@SessionAttributes(value={"user"})
public class UserLoginLogoutController {
	
	@RequestMapping(value="/login")
	public String login(EmployeeModel user,HttpSession session) throws Exception{
		session.setAttribute("user", user);
		return "redirect:/home/tomain.mvc";
	}
}
