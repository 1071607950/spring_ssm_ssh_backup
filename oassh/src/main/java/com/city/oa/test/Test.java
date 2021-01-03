package com.city.oa.test;

import java.util.List;

import com.city.oa.factory.ServiceFactory;
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
		IDepartmentService ds01=ServiceFactory.createDepartmentService();
		
		
		
		IEmployeeService es=new EmployeeServiceImplWithHibernate();
		
		EmployeeModel em=new EmployeeModel();
		
		em.setId("8888");
		em.setPassword("8888");
		em.setName("发发发");
		em.setSex("男");
		em.setAge(27);
		em.setSalary(7777);
		em.setCardcode("230221829202020220");
		
		DepartmentModel dm=new DepartmentModel();
		dm.setNo(9);
		dm.setCode("DX100");
		dm.setName("新的测试部门");
		
		
		
		//dm.setNo(3);
		//设置员工关联的部门
		//em.setDepartment(dm);
		
		//创建员工的地址类对象
		AddressModel am=new AddressModel();
		//am.setId("7777");
		am.setCity("大连");
		am.setAddress("中山路");
		am.setPostcode("10080");
		//将地址类对象与员工类对象进行双向关联
		em.setAddress(am);
		am.setEmployee(em);
		
		//创建员工联系对象
		ContactInfoModel cim=new ContactInfoModel();
		//cim.setNo(4);
		cim.setMail("888@777.com");
		cim.setMobile("8888");
		cim.setQq("88888");
		//与员工Model类对象进行双向一对一关联
		cim.setEmployee(em);
		em.setContactInfo(cim);
		
		
		try {
			//es.add(em); //测试增加员工，检查是否级联增加地址表的记录
			//es.modify(em);
			//es.delete(em);
			
			//ds.add(dm);
			//ds.delete(dm);
			
			
			
			//dm=ds.getByNo(10);
			//System.out.println(dm.getCode());
			//ds.modify(dm);
			
			
			//es.changePassword("1001", "111111");
			
			
			//em=es.getById("8888");
			//System.out.println(em.getDepartment().getNo());
			//System.out.println(em.getDepartment().getName());
			//System.out.println(em.getName());
			//System.out.println(em.getAddress().getCity());
			
			
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
			
			//es.addBehave("1001",2);
			
			
			//es.addBehaves("1001", new int[] {1,2,4});
			
			//es.deleteBehave("1001", 2);
			
			//es.deleteAllBehaves("1001");
			//System.out.println(es.chechHaveBehave("1001", 2));
			
			//===============测试一对一关联关系==================
			//测试增加
			//es.add(em);  
			//测试修改
			//es.modify(em);
			//测试删除
			//es.delete(em);
			//测试查询
			
			/*
			em=es.getById("7777");
			System.out.println(em.getId());
			System.out.println(em.getName());
			System.out.println(em.getAddress().getAddress());
			System.out.println(em.getContactInfo().getMail());
			System.out.println(em.getDepartment().getName());
			*/
			
			//System.out.println(ds.getCountByAll());
			//======================HQL内关联查询方法测试===============================
			//dm=ds.getByNoWithEmployees(3);
			//System.out.println(dm.getEmployees().size());
			
			
			/*
			List<Object[]> list01=es.getListAndDepartment();
			for(Object[] os:list01) {
				em=(EmployeeModel)os[0];
				dm=(DepartmentModel)os[1];
				System.out.println(em.getName()+"----"+dm.getName());
			}
			*/
			
			/*抓取内关联查询测试
			List<DepartmentModel> list001=ds.getListWithEmployees();
			System.out.println(list001.size());
			for(DepartmentModel dm001:list001) {
				System.out.println(dm001.getName()+"="+dm001.getEmployees().size());
			}
			*/
			/* 普通外关联查询  
			List<Object[]> list01=ds.getListAndEmployee();
			for(Object[] os:list01) {
				dm=(DepartmentModel)os[0];
				em=(EmployeeModel)os[1];
				
				if(em!=null) {
					System.out.println(dm.getName()+"----"+em.getName());
				}
				else {
					System.out.println(dm.getName()+"----null");
				}
				
			}
			*/
			
			/* 抓取外关联查询测试   
			List<DepartmentModel> list002=ds.getListWithOrWithoutEmployees();
			for(DepartmentModel dm002:list002) {
				
				if(dm002.getEmployees()!=null) {
					System.out.println(dm002.getName()+"----"+dm002.getEmployees().size());
				}
				else {
					System.out.println(dm002.getName()+"----null");
				}
				
			}
			*/
						
			//===================HQL外关联查询方法测试=================================
			//List<EmployeeModel> list02=es.getListUsingLeftOuterJoinWithDepartment();
			//System.out.println(list02.size());
			/*
			List<Object[]> list03=es.getEmployeeNameAndDepartmentNameList();
			System.out.println(list03.size());
			for(Object[] ao:list03) {
				System.out.println(ao[0]+"---"+ao[1]);
			}
			*/
			/*
			List<Object[]> list04=ds.getDepartmentAndTotalSalary(5000, 8000);
			System.out.println(list04.size());
			for(Object[] ao:list04) {
				System.out.println( ((DepartmentModel)ao[0]).getName()+"---"+ao[1]);
			}
			*/
			
			//System.out.println(ds.getMaxAvgSalaryOfDepartment());
			
			//取得没有任何爱好的员工
			List<EmployeeModel> list=es.getListWithoutAnyBehaves();
			System.out.println(list.size());
			for(EmployeeModel em01:list) {
				System.out.println(em01.getId()+"----"+em01.getName());
			}
			
			/* HQL子查询测试 
			List<EmployeeModel> list=es.getListByGreateThanDepartmentSalaryAvg();
			System.out.println(list.size());
			for(EmployeeModel em01:list) {
				System.out.println(em01.getName()+"="+em01.getSalary());
			}
			*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
