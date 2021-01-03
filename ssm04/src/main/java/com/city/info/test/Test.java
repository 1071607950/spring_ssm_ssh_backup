package com.city.info.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.city.info.config.SpringConfig;
import com.city.info.model.ClassModel;
import com.city.info.model.CourseModel;
import com.city.info.model.StudentModel;
import com.city.info.service.IStudentService;

public class Test {

	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		IStudentService ss=ac.getBean("StudentService",IStudentService.class);
		StudentModel sm=new StudentModel();
		ClassModel cm=new ClassModel();
		cm.setNo(1);
		sm.setName("李四");
		sm.setAge(20);
		sm.setSex("女");
		sm.setCla(cm);
		
		try {
			ss.add(sm);
			ss.addCourse(1, new int[] {1,2});
			for(CourseModel list:ss.getCoursesByStudent(1)) {
				System.out.println("编号:"+list.getNo()+"名称:"+list.getName());
			}
			
			for(CourseModel list:ss.getCoursesWithoutSelected()) {
				System.out.println("编号:"+list.getNo()+"名称:"+list.getName());
			}
			
			System.out.println("人数:"+ss.getStudentCountBySexAndCourse("男", 1));
			
			for(StudentModel list:ss.getListBySearchCondition("男", "张", 20, 30)) {
				System.out.println("学生姓名:"+list.getName()+"班级:"+list.getCla().getName());
			}
			
			for(StudentModel list:ss.getListBySearchCondition01("男", "张", 20, 30)) {
				System.out.println("学生姓名:"+list.getName()+"班级:"+list.getCla().getName()+"选课:");
				for(CourseModel list1:list.getCourses()) {
					System.out.println(list1.getName());
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
