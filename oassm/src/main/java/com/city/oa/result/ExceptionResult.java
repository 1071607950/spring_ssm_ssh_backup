package com.city.oa.result;

//异常结果类
public class ExceptionResult {
	
	private String status=null; //OK 正常，ERROR:异常
	private String message=null;
	private Class<?> exceptionClass=null;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Class<?> getExceptionClass() {
		return exceptionClass;
	}
	public void setExceptionClass(Class<?> exceptionClass) {
		this.exceptionClass = exceptionClass;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
