package com.city.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.city.erp.dao.IProductDao;
import com.city.erp.model.ProductModel;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductDao productDao=null;
	
	@RequestMapping("/toadd")
	public String toadd() throws Exception {
		return "product/add";
	} 
	
	//增加产品方法， 请求地址为：/add，返回：重定向到取得产品列表的控制器方法。
	@RequestMapping("/add")
	public String add(ProductModel pm) throws Exception {
		productDao.insert(pm);
		return "redirect:/product/tolist.do";
	} 
	//取得产品列表，保存产品列表，转发到产品显示页面。映射地址： /tolist
	@RequestMapping("/tolist")
	public String tolist(Model model) throws Exception {
		model.addAttribute("productList",productDao.selectListByAll());
		return "product/list";
	}
}
