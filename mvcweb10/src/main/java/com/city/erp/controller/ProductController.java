package com.city.erp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(ProductModel pm,@RequestParam(required=false) MultipartFile productPhoto) throws Exception {
		if(productPhoto!=null&&(!productPhoto.isEmpty())) {
			pm.setPhotoContentType(productPhoto.getContentType());
			pm.setPhotoFileName("photo"+pm.getName()+new SimpleDateFormat("yyyy-mm-dd HH:mm:dd").format(new Date())+ productPhoto.getOriginalFilename().substring(productPhoto.getOriginalFilename().lastIndexOf(".")));
			pm.setPhoto(productPhoto.getBytes());
		}
		productService.add(pm);
		return "redirect:/product/tolist.do";
	} 
	//取得产品列表，保存产品列表，转发到产品显示页面。映射地址： /tolist
	@RequestMapping("/tolist")
	public String tolist(@RequestParam(value="low",required=false,defaultValue="0") double low,@RequestParam(value="high",required=false,defaultValue="0") double high,@RequestParam(value="page",required=false,defaultValue="1") int page,Model model) throws Exception {
		int rows=3;
		model.addAttribute("low",low);
		model.addAttribute("high",high);
		model.addAttribute("count",productService.getCountByPrice(low, high));
		model.addAttribute("page",page);
		model.addAttribute("pagecount",productService.getPageCountByPrice(low, high, rows));
		model.addAttribute("productList",productService.getListByPriceWithPage(low, high, page, rows));
		
		return "product/list";
	}
	
	@RequestMapping("/toview")
	public String toview(@RequestParam("no") int no,Model model) throws Exception{
		model.addAttribute("pm",productService.getByIdWithPhoto(no));
		return "product/view";
	}
	
	@RequestMapping("/showphoto")
	public ResponseEntity<byte[]> showPhoto(@RequestParam int no) throws Exception{
		ProductModel pm=productService.getByIdWithPhoto(no);
		if(pm!=null&&pm.getPhotoContentType()!=null) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Content-Type", pm.getPhotoContentType());
			return new ResponseEntity<byte[]>(pm.getPhoto(), responseHeaders,HttpStatus.OK);
		}
		else {
			return null;
		}	
		
	}
}
