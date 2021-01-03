package com.city.info.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.city.info.config.SpringConfig;
import com.city.info.model.StudentModel;
import com.city.info.service.IStudentService;

public class Test {

	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		IStudentService ss=ac.getBean("StudentService",IStudentService.class);
		StudentModel sm=new StudentModel();
		sm.setName("丁六");
		sm.setCno(2);
		sm.setAge(21);
		sm.setSex("男");
		try {
			ss.add(sm);
			
			for(StudentModel list:ss.getListByClass(1)) {
				System.out.println("编号:"+list.getNo()+",姓名:"+list.getName()+",班级:"+list.getCno()+",年龄:"+list.getAge()+",性别:"+list.getSex());
			}
			
			System.out.println("平均年龄:"+ss.getAvgAgeByClass(1));
			
			for(StudentModel list:ss.getListByAll()) {
				System.out.println("编号:"+list.getNo()+",姓名:"+list.getName()+",班级:"+list.getCno()+",年龄:"+list.getAge()+",性别:"+list.getSex());
			}
			
			for(StudentModel list:ss.getListByAllWithPage(2, 2)) {
				System.out.println("编号:"+list.getNo()+",姓名:"+list.getName()+",班级:"+list.getCno()+",年龄:"+list.getAge()+",性别:"+list.getSex());
			}
			
			for(StudentModel list:ss.getListByCondition(1, "", 20, 30)) {
				System.out.println("编号:"+list.getNo()+",姓名:"+list.getName()+",班级:"+list.getCno()+",年龄:"+list.getAge()+",性别:"+list.getSex());
			}
			
			System.out.println("平均年龄:"+ss.getAvgAgeByCondition(1, null, 0, 0));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
