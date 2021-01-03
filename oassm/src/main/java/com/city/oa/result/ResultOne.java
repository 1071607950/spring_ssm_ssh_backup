package com.city.oa.result;

//返回单个数据或对象的结果
public class ResultOne<T> {
	private T result=null; //返回结果
	private String status=null; //状态 OK 正常， ERROR：异常
	private String message=null; //操作信息，如果是异常就是异常原因
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
