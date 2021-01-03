package com.city.oa.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.city.oa.model.DepartmentModel;
import com.city.oa.result.ResultList;
import com.city.oa.result.ResultOne;
import com.city.oa.service.IDepartmentService;

//基于REST API的部门控制器,没有前分发控制方法，只有取得查询数据和后处理，所有方法的返回结果都是JSON
@RestController  // @Controller+@ResponseBody
@RequestMapping("/api/department/")
public class DepartmentRestController {
	@Autowired
	private IDepartmentService departmentService=null;
	
	//接收JSON部门提交数据
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultOne<String> add(DepartmentModel dm) throws Exception{
		departmentService.add(dm);
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("OK");
		result.setMessage("增加部门成功");
		return result;
	}
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultOne<String> modify(DepartmentModel dm) throws Exception{
		departmentService.modify(dm);
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("OK");
		result.setMessage("修改部门成功");
		return result;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultOne<String> delete(DepartmentModel dm) throws Exception{
		departmentService.delete(dm);
		ResultOne<String> result=new ResultOne<String>();
		result.setStatus("OK");
		result.setMessage("删除部门成功");
		return result;
		
	}
	//取得指定的部门对象
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ResultOne<DepartmentModel> getByNo(@RequestParam int no) throws Exception{
		
		ResultOne<DepartmentModel> result=new ResultOne<DepartmentModel>();
		result.setStatus("OK");
		result.setMessage("取得指定部门成功");
		result.setResult(departmentService.getByNoWithoutEmployees(no));
		return result;
		
	}
	
	
	//取得所有的部门列表,不分页模式
	@RequestMapping(value="/list/all")
	public ResultList<DepartmentModel> getListByAll() throws Exception{
		//int m=10/0;
		ResultList<DepartmentModel> result=new ResultList<DepartmentModel>();
		result.setList(departmentService.getListByAll());
		result.setStatus("OK");
		result.setMessage("取得部门列表全部成功");
		return result;
	}
	//取得所有的部门列表,分页模式
	@RequestMapping(value="/list/all/page")
	@ResponseBody
	public ResultList<DepartmentModel> getListByAllWithPage(@RequestParam(value="rows",required=false,defaultValue="10") int rows,@RequestParam(value="page",required=false,defaultValue="1") int page) throws Exception{
		
		ResultList<DepartmentModel> result=new ResultList<DepartmentModel>();
		result.setCount(departmentService.getCountByAll());
		result.setPage(page);
		result.setRows(rows);
		result.setPageCount(departmentService.getPageCountByAll(rows));
		result.setList(departmentService.getListByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("取得部门列表分页方式成功");
		return result;
	}
		
	
	

}
