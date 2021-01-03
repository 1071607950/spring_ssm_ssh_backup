package com.city.erp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.city.erp.model.ProductModel;
import com.city.erp.result.Result;
import com.city.erp.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService=null;
	
	//增加产品方法， 请求地址为：/add，接收：表单提交格式的数据；返回：Result对象的属性status="OK"。
	@RequestMapping("/add")
	public Result<String> add(ProductModel pm) throws Exception{
		productService.add(pm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setStringResult("增加产品成功");
		return result;
	}
	
	//增加产品方法， 请求地址为：/add/json，接收：JSON提交格式的数据；返回：Result对象的属性status="OK"。
	@RequestMapping("/add/json")
	public Result<String> addFromJSON(@RequestBody ProductModel pm) throws Exception{
		productService.add(pm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setStringResult("增加产品成功");
		return result;
	}
	
	//取得指定产品,返回JSON格式的产品信息。 地址：/get；返回：Result对象的属性model为产品对象，status="OK"
	@RequestMapping("/get")
	public Result<ProductModel> getByNo(@RequestParam int productNo) throws Exception{
		Result<ProductModel> result=new Result<ProductModel>();
		result.setModel(productService.getByNo(productNo));
		result.setStatus("OK");
		result.setStringResult("查询产品成功");
		return result;
	}
	
	//取得所有的产品列表, 分页模式；接收参数： rows 不是必须的，默认值是10； page 不是必须的，默认值是1. 返回：JSON格式的产品列表。地址：/list/all/page；返回：Result类对象：包含产品列表，产品个数，产品页数，page，rows，状态status:OK
	@RequestMapping("/list/all/page")
	public Result<ProductModel> getListByAllWithPage(@RequestParam(value = "rows",required = false,defaultValue = "10") int rows,@RequestParam(value = "page",required = false,defaultValue = "1") int page) throws Exception{
		Result<ProductModel> result=new Result<ProductModel>();
		result.setList(productService.getListByAllWithPage(rows, page));
		result.setCount(productService.getCountByAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(productService.getPageCount(rows));
		result.setStatus("OK");
		result.setStringResult("查询产品列表成功");
		return result;
	}
	
	//取得所有产品的累计金额
	@RequestMapping("/getamount")
	public Result<Double> getAmountByAll() throws Exception{
		Result<Double> result=new Result<Double>();
		result.setDoubleResult(productService.getTotalAmountByAll());
		result.setStatus("OK");
		result.setStringResult("查询总价格成功");
		return result;
	}
	
	
	
}
