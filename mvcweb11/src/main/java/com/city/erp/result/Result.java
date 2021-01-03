package com.city.erp.result;

import java.util.Date;
import java.util.List;

public class Result<T> {
	int count=0; // 对象的总个数
	int pageCount=0; //总页数
	int page=0; //当前页序号
	int rows=0; //每页显示的个数
	List<T> list=null; //查询结果集合
	T model=null; //单个查询对象
	int intResult=0; //int类型结果
	double doubleResult=0; //double类型结果
	Date dateResult=null; //Date类型结果
	String stringResult=null; //String类型结果
	String status=null;  //操作的结果，一般正常值是：OK，不正常：ERROR
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public T getModel() {
		return model;
	}
	public void setModel(T model) {
		this.model = model;
	}
	public int getIntResult() {
		return intResult;
	}
	public void setIntResult(int intResult) {
		this.intResult = intResult;
	}
	public double getDoubleResult() {
		return doubleResult;
	}
	public void setDoubleResult(double doubleResult) {
		this.doubleResult = doubleResult;
	}
	public Date getDateResult() {
		return dateResult;
	}
	public void setDateResult(Date dateResult) {
		this.dateResult = dateResult;
	}
	public String getStringResult() {
		return stringResult;
	}
	public void setStringResult(String stringResult) {
		this.stringResult = stringResult;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
