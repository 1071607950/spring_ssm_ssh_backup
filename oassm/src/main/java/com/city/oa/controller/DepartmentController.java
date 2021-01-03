package com.city.oa.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.city.oa.model.DepartmentModel;
import com.city.oa.result.ExceptionResult;
import com.city.oa.service.IDepartmentService;
//部门Spring MVC控制器
@Controller
@RequestMapping(value="/department")
public class DepartmentController {
	
	@Autowired
	private IDepartmentService departmentService=null; //部门业务层对象
	
	//部门主页前分发控制方法
	@RequestMapping(value="/tomain",method=RequestMethod.GET)
	public String tomain(Model model) throws Exception{
		List<DepartmentModel> list=departmentService.getListByAll();
		model.addAttribute("departmentList", list); //传递给JSP显示的数据
		//int m=10/0;
		return "department/main";
		// 转发到 /department/main.jsp 
	}
	//部门增加前分发控制方法
	@GetMapping(value="/toadd")
	public ModelAndView toadd(Model model) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("info", "您好");
		mv.setViewName("department/add");
		return mv;
		 
	}
	
	//部门修改前分发控制方法，接收需求修改部门的编号
	@GetMapping(value="/tomodify")
	public String tomodify(@RequestParam int no,Model model) throws Exception{
		DepartmentModel dm=departmentService.getByNoWithoutEmployees(no); //取得指定的部门对象
		model.addAttribute("dm",dm); //将部门对象传递给修改JSP页面
		return "department/modify";
	}
	
	//部门删除前分发控制方法，接收需求修改部门的编号
	@GetMapping(value="/todelete{no}")
	public String todelete(@PathVariable int no,Model model) throws Exception{
		
		DepartmentModel dm=departmentService.getByNoWithoutEmployees(no); //取得指定的部门对象
		model.addAttribute("dm",dm); //将部门对象传递给修改JSP页面
		return "department/delete";
	}
	//部门修改前分发控制方法，接收需求修改部门的编号
	@GetMapping(value="/toview")
	public String toview(@RequestParam(value="no",required=false,defaultValue="0") int no,Model model) throws Exception{
		DepartmentModel dm=departmentService.getByNoWithoutEmployees(no); //取得指定的部门对象
		model.addAttribute("dm",dm); //将部门对象传递给修改JSP页面
		return "department/view";
	}
	//部门增加后处理控制方法
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(DepartmentModel dm) throws Exception{
		departmentService.add(dm);
		return "redirect:/department/tomain.mvc";
	}
	
	//部门修改后处理控制方法
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(DepartmentModel dm) throws Exception{
		departmentService.modify(dm);
		return "redirect:/department/tomain.mvc";
	}
	
	//部门删除后处理控制方法
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(DepartmentModel dm) throws Exception{
		departmentService.delete(dm);
		return "redirect:/department/tomain.mvc";
	}
	
	@RequestMapping(value="/headers",method=RequestMethod.GET)
	public HttpHeaders testHeader() throws Exception{
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Test Info");
		return headers;
	}
	
	@GetMapping("/bodyandheader")
	public ResponseEntity<String> handle() {
		String body="Info Body";
		String etag="Info ETag";
		return ResponseEntity.ok().eTag(etag).body(body);
	}
	
	@RequestMapping("/responsewithhttpentity")
	public HttpEntity<String> responseWithHttpEntity() throws Exception {
	   HttpHeaders responseHeaders = new HttpHeaders();
	   responseHeaders.set("Header01", "Value01");
	   responseHeaders.set("Header02", "Value02");
	   responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
	   return new HttpEntity<String>("你好Hello World", responseHeaders);
	 }
	
	//取得所有的部门列表
	@RequestMapping(value="/list/all")
	@ResponseBody
	public List<DepartmentModel> getListByAll() throws Exception{
		return departmentService.getListByAll();
	}
	//部门控制器异常处理
	/*
	@ExceptionHandler({IOException.class,RuntimeException.class})
	public String exceptionHandler(Exception ex,Model model) throws Exception{
		model.addAttribute("errorMessage", ex.getMessage());
		return "error/error";
	}
	*/
	
}
