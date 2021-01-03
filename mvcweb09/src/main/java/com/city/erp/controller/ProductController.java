package com.city.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService=null;
	
	@RequestMapping("/toadd")
	public String toadd() throws Exception {
		return "product/add";
	} 
	
	//增加产品方法， 请求地址为：/add，返回：重定向到取得产品列表的控制器方法。
	@RequestMapping("/add")
	public String add(ProductModel pm) throws Exception {
		productService.add(pm);
		return "redirect:/product/tolist.do";
	} 
	//取得产品列表，保存产品列表，转发到产品显示页面。映射地址： /tolist
	@RequestMapping("/tolist")
	public String tolist(@RequestParam(value="low",required=false,defaultValue="0") double low,@RequestParam(value="high",required=false,defaultValue="0") double high,@RequestParam(value="page",required=false,defaultValue="1") int page,Model model) throws Exception {
		int rows=5;
		model.addAttribute("low",low);
		model.addAttribute("high",high);
		model.addAttribute("count",productService.getCountByPrice(low, high));
		model.addAttribute("page",page);
		model.addAttribute("pagecount",productService.getPageCountByPrice(low, high, rows));
		model.addAttribute("productList",productService.getListByPriceWithPage(low, high, page, rows));
		
		return "product/list";
	}
}
