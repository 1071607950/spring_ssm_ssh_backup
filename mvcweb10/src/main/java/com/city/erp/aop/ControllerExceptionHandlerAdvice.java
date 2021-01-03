package com.city.erp.aop;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//控制器异常捕获Advice
@Component
@ControllerAdvice
public class ControllerExceptionHandlerAdvice {
	@ExceptionHandler
	public String exceptionHandler(Model model,Exception ex) throws Exception{
		model.addAttribute("errorMessage",ex.getLocalizedMessage());
		return "/error/error";
	}
	
}
