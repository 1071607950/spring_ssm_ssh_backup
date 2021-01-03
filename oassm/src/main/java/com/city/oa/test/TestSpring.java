package com.city.oa.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.city.oa.config.SpringConfigForMyBatis;

import com.city.oa.model.AddressModel;
import com.city.oa.model.ContactInfoModel;
import com.city.oa.model.DepartmentModel;
import com.city.oa.model.EmployeeModel;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.IEmployeeService;

//测试Spring集成MyBatis

public class TestSpring {

	public static void main(String[] args) {
		
		//ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfigForMyBatis.class);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontextforssm.xml");
		
		
		
		
		
		IEmployeeService es=ac.getBean("employeeServiceWithMyBatis",IEmployeeService.class);
		IDepartmentService ds=ac.getBean("DepartmentServiceWithSSM",IDepartmentService.class);
		
		DepartmentModel dm=new DepartmentModel();
		dm.setNo(27);
		dm.setCode(null);
		dm.setName("流通部");
		
		
		EmployeeModel em=new EmployeeModel();
		em.setId("1006");
		em.setPassword("1006");
		em.setName("胡海泉");
		em.setSex("男");
		em.setAge(30);
		em.setSalary(5000);
		em.setBirthday(new Date());
		em.setJoinDate(new Date());
		
		em.setDepartment(dm);
		
		AddressModel am=new AddressModel();
		am.setAddress("铁山西路");
		am.setCity("大连");
		am.setPostcode("116600");
		am.setEmployee(em);
		
		ContactInfoModel cim=new ContactInfoModel();
		cim.setMail("123@qq.com");
		cim.setMobile("1452222282");
		cim.setQq("2202020202");
		cim.setEmployee(em);
		
		em.setAddress(am);
		em.setContactInfo(cim);
		
		try {
			//测试部门方法
			//取得指定的部门和关联的员工集合
			dm=ds.getByNoWithEmployees(1);
			System.out.println(dm.getName());
			System.out.println(dm.getEmployees().size());
			
			//List<DepartmentModel> list=ds.getListByAllWithEmployees();
			/*
			for(DepartmentModel dm01:list) {
				System.out.println(dm01.getName());
				System.out.println(dm01.getEmployees().size());
			}
			*/
			
			
			
			//ds.modify(dm);
			
			//es.add(em);
			//es.addBehave("1005", 1);
			//es.addBehaves("1006",new int[] {2,3,4});
			
			//em=es.getByIdWithDepartment("1003");
			//System.out.println(em.getName());
			//System.out.println(em.getDepartment().getName());
			
			
			/*
			em=es.getByIdWithDepartmentAddressContactInfoBehaves("1006");
			
			System.out.println(em.getAddress().getAddress());
			System.out.println(em.getContactInfo().getMail());
			*/
			
			//List<EmployeeModel> list=es.getListByBehaves(new int[] {1,2,4});
			//System.out.println(list.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
