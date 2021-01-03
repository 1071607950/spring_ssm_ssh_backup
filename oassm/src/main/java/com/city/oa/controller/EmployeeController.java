package com.city.oa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.city.oa.model.BehaveModel;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IBehaveService;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;

//员工控制器类

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService=null;
	@Autowired
	private IBehaveService behaveService=null;
	@Autowired
	private IDepartmentService departmentService=null;
	//员工主页前分发
	@RequestMapping(value="/tomain",method={RequestMethod.GET,RequestMethod.POST})
	//@GetMapping("/tomain")
	public String tomain(Model model) throws Exception{
		List<EmployeeModel> list=employeeService.getListByAllWithDepartment();
		model.addAttribute("emplist", list);
		return "employee/main";
	}
	//员工增加前分发
	@RequestMapping(value="/toadd")
	public String toadd(Model model) throws Exception{
		List<DepartmentModel> departmentList=departmentService.getListByAll();
		List<BehaveModel> behaveList=behaveService.getListByAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("behaveList", behaveList);
		return "employee/add";
	}
	
	//员工修改前分发
	@RequestMapping(value="/tomodify")
	public String tomodify(@RequestParam String id,Model model) throws Exception{
		EmployeeModel em=employeeService.getById(id);
		List<DepartmentModel> departmentList=departmentService.getListByAll();
		List<BehaveModel> behaveList=behaveService.getListByAll();
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("behaveList", behaveList);
		model.addAttribute("em", em);
		return "employee/modify";
	}
	
	//员工修改前分发
	@RequestMapping(value="/toview")
	public String toview(@RequestParam String id,Model model) throws Exception{
		EmployeeModel em=employeeService.getById(id);
		model.addAttribute("em", em);
		return "employee/view";
	}
	
	//增加员工后处理
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(EmployeeModel em, @RequestParam(required=false) MultipartFile employeePhoto,HttpServletRequest request) throws Exception{
		if(employeePhoto!=null&&(!employeePhoto.isEmpty())) {
			em.setPhotoContentType(employeePhoto.getContentType());
			em.setPhotoFileName("photo"+em.getId()+ employeePhoto.getOriginalFilename().substring(employeePhoto.getOriginalFilename().lastIndexOf(".")));
			em.setPhoto(employeePhoto.getBytes());
			
			//上传文件保存到操作系统指定的文件目录
			//File file=new File("e:/upload/"+employeePhoto.getOriginalFilename());
			//employeePhoto.transferTo(file);
			
			/* 上传文件保存到Web站点的指定目录
			ServletContext application=request.getServletContext();
			String path=application.getRealPath("/WEB-INF/upload/"+employeePhoto.getOriginalFilename());
			File file=new File(path);
			employeePhoto.transferTo(file);
			*/
			
			
		}
		employeeService.add(em);
		
		return "redirect:/employee/tomain.mvc";
	}
	
	
	
	//取得所有员工列表，不取关联的部门对象
	
	//员工图片下载方法01
	@RequestMapping("/showphoto01")
	public void showPhoto(@RequestParam String id,HttpServletResponse response) throws Exception{
		EmployeeModel em=employeeService.getByIdWithPhoto(id);
		if(em!=null&&em.getPhotoContentType()!=null) {
			response.setContentType(em.getPhotoContentType());
			OutputStream out=response.getOutputStream();
			out.write(em.getPhoto());
			out.flush();
			out.close();
		}
	}
	
	//员工照片下载方法02
	@RequestMapping("/showphoto02")
	public HttpEntity<byte[]> showPhoto02(@RequestParam String id) throws Exception{
		EmployeeModel em=employeeService.getByIdWithPhoto(id);
		if(em!=null&&em.getPhotoContentType()!=null) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Content-Type", em.getPhotoContentType());
			return new HttpEntity<byte[]>(em.getPhoto(), responseHeaders);
		}
		else {
			return null;
		}
	}
	//显示或下载员工的照片字段photo
	@RequestMapping("/showphoto03")
	public ResponseEntity<byte[]> showPhoto03(@RequestParam String filename) throws Exception{
		File file = new File("e:/download/"+filename);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "image/jpeg");
        return new ResponseEntity<byte[]>(body, responseHeaders, HttpStatus.OK);;    

		
//		EmployeeModel em=employeeService.getByIdWithPhoto(id);
//		if(em!=null&&em.getPhotoContentType()!=null) {
//			HttpHeaders responseHeaders = new HttpHeaders();
//			responseHeaders.set("Content-Type", em.getPhotoContentType());
//			return new ResponseEntity<byte[]>(em.getPhoto(), responseHeaders,HttpStatus.OK);
//		}
//		else {
//			return null;
//		}	
		
	}
	
	@RequestMapping("/showphoto04")
	public void showPhoto04(@RequestParam String filename,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ServletContext application=request.getServletContext();
		String path=application.getRealPath("/WEB-INF/upload/"+filename);
		File file=new File(path);
		String realname=filename.substring(filename.indexOf("_"+1));
		response.setHeader("content-dispposition", "attachment;filename="+URLEncoder.encode(realname,"UTF-8"));
		FileInputStream in =new FileInputStream(file);
		OutputStream out=response.getOutputStream();
		byte buffer[]=new byte[1024];
		int len=0;
		while((len=in.read(buffer))>0) {
			out.write(buffer,0,len);
			
		}
		in.close();
		out.close();
	}
}
