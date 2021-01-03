package com.city.oa.test;

import java.util.List;

import com.city.oa.model.AddressModel;
import com.city.oa.model.ContactInfoModel;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;
import com.city.oa.service.impl.DepartmentServiceImplWithHibernate;
import com.city.oa.service.impl.EmployeeServiceImplWithHibernate;

public class Test {

	public static void main(String[] args) {
		IDepartmentService ds=new DepartmentServiceImplWithHibernate();
		IEmployeeService es=new EmployeeServiceImplWithHibernate();
		EmployeeModel em=new EmployeeModel();
		em.setId("8888");
		em.setPassword("8888");
		em.setName("张三");
		em.setSex("男");
		em.setAge(30);
		em.setSalary(6000);
		em.setCardcode("23022182920202020222");
		DepartmentModel dm=new DepartmentModel();
		dm.setNo(3);
		//设置员工关联的部门
		em.setDepartment(dm);
		
		//创建员工的地址类对象
		
		AddressModel am=new AddressModel();
		//am.setId("8888");
		am.setCity("大连");
		am.setAddress("中山");
		am.setPostcode("10080");
		//将地址类对象与员工类对象进行关联
		em.setAddress(am);
		am.setEmployee(em);
		
		//创建员工联系对象
		ContactInfoModel cim=new ContactInfoModel();
		//cim.setNo(1);
		cim.setMail("8888@qq.com");
		cim.setMobile("12312341234");
		cim.setQq("12345678");
		
		//与员工Model类对象进行双向一对一关联
		cim.setEmployee(em);
		em.setContactInfo(cim);
		
		try {
			//es.add(em);
			//es.modify(em);
			//es.delete(em);
			//ds.add(dm);
			//dm.ds.getByNo(1);
			//ds.modify(dm);
			//System.out.println(dm.getName());
			/*
			em=es.getById("1001");
			System.out.println(em.getDepartment().getNo());
			System.out.println(em.getDepartment().getName());
			*/
			/*
			List<EmployeeModel> list=es.getListByDepartment(1);
			System.out.println(list.size());
			for(EmployeeModel em01:list) {
				System.out.println(em01.getName());
			}
			*/
			/*
			dm=ds.getByNo(1);
			System.out.println(dm.getEmployees().size());
			for(EmployeeModel em01:dm.getEmployees()) {
				System.out.println(em01.getName());
			}
			*/
			//es.addBehave("1001", 2);
			//es.addBehaves("1001", new int[] {1,2,4});
			//es.deleteBehave("1001", 2);
			//es.deleteAllBehaves("1001");
			//System.out.println(es.checkHaveBehave("1001", 2));
			
			em=es.getById("8888");
			System.out.println(em.getAddress().getAddress());
			System.out.println(em.getContactInfo().getMail());
			System.out.println(em.getDepartment().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
