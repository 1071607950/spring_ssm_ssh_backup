package com.city.oa.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city.oa.result.ResultOne;

//控制器异常捕获Advice
@Component
@ControllerAdvice
public class ControllerExceptionHandlerAdvice {
	//@ExceptionHandler({Exception.class})
	@ExceptionHandler
	@ResponseBody
	public ResultOne<String> exceptionHandler(Exception ex) throws Exception{
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("ERROR");
		result.setResult("请求出现异常");
		result.setMessage("异常原因:"+ex.getLocalizedMessage());
		return result;
	}
	
}
