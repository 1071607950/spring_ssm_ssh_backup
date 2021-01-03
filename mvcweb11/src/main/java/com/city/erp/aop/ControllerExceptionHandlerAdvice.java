package com.city.erp.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city.erp.result.Result;

//控制器异常捕获Advice
@Component
@ControllerAdvice
public class ControllerExceptionHandlerAdvice {
	@ExceptionHandler
	@ResponseBody
	public Result<String> exceptionHandler(Exception ex) throws Exception{
		Result<String> result=new Result<String>();
		result.setStatus("ERROR");
		result.setStringResult("请求出现异常");
		result.setModel("异常原因:"+ex.getLocalizedMessage());
		return result;
	}
	
}
