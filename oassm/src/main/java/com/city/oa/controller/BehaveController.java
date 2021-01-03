package com.city.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.oa.model.BehaveModel;
import com.city.oa.service.IBehaveService;

//爱好控制器类
@Controller
@RequestMapping("/behave")
public class BehaveController {
	@Autowired
	private IBehaveService behaveService=null;
	
	//主页的前分发
	@RequestMapping("/tomain")
	public String tomain(Model model) throws Exception{
		List<BehaveModel> list=behaveService.getListByAll();
		model.addAttribute("behaveList",list);
		
		return "behave/main";
	}
	
	//增加的前分发
	@RequestMapping("/toadd")
	public String toadd(Model model) throws Exception{
		
		return "behave/add";
	}
	//修改的前分发
	@RequestMapping("/tomodify")
	public String tomodify(@RequestParam int no,Model model) throws Exception{
		BehaveModel bm=behaveService.getByNo(no);
		model.addAttribute("bm",bm);
		return "behave/modify";
	}
	//删除的前分发
	@RequestMapping("/todelete")
	public String todelete(@RequestParam int no,Model model) throws Exception{
		BehaveModel bm=behaveService.getByNo(no);
		model.addAttribute("bm",bm);
		return "behave/delete";
	}
	
	//查看的前分发
	@RequestMapping("/toview")
	public String toview(@RequestParam int no,Model model) throws Exception{
		BehaveModel bm=behaveService.getByNo(no);
		model.addAttribute("bm",bm);
		return "behave/view";
	}
	//增加后处理
	@RequestMapping("/add")
	public String add(BehaveModel bm) throws Exception{
		behaveService.add(bm);
		return "redirect:/behave/tomain.mvc";
	}
	
	//修改后处理
	@RequestMapping("/modify")
	public String modify(BehaveModel bm) throws Exception{
		behaveService.modify(bm);
		return "redirect:/behave/tomain.mvc";
	}
	
	//删除后处理
	@RequestMapping("/delete")
	public String delete(BehaveModel bm) throws Exception{
		behaveService.delete(bm);
		return "redirect:/behave/tomain.mvc";
	}
	
}
