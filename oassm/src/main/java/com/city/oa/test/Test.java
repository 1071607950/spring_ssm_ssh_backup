package com.city.oa.test;

import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;
import com.city.oa.service.impl.DepartmentServiceImplWithMyBatis;
import com.city.oa.service.impl.EmployeeServiceImplWithMyBatis;

public class Test {

	public static void main(String[] args) {
		
		DepartmentModel dm=new DepartmentModel();
		//dm.setNo(26);
		dm.setCode("D100");
		dm.setName("D100部");
		
		IDepartmentService ds=new DepartmentServiceImplWithMyBatis();
		
		
		
		try {
			IEmployeeService es=new EmployeeServiceImplWithMyBatis();
			
			EmployeeModel em=new EmployeeModel();
			em=es.getByIdWithDepartment("1004");
			System.out.println(em.getName());
			System.out.println(em.getDepartment().getName());
			
			//ds.add(dm);
			//System.out.println("新增加的部门编号："+dm.getNo());
			//ds.modify(dm);
			//ds.delete(dm);
			
			System.out.println("OK...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
