package com.city.oa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.city.oa.config.SpringConfig;
import com.city.oa.model.CourseModel;
import com.city.oa.model.StudentModel;
import com.city.oa.service.IStudentService;

//测试Spring应用
public class Test {
	private static ApplicationContext ac;
	public static void main(String[] args) {
		//创建Spring IOC容器对象
		//使用XML配置文件
		//ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//使用Java配置方式
		ac=new AnnotationConfigApplicationContext(SpringConfig.class);
		//取得Spring IOC容器管理的部门业务对象
		IStudentService ss=ac.getBean("studentService",IStudentService.class);
		
		try {
			System.out.println("1.增加学生");
			//ss.add("4", "丁六", "女", 25);
			System.out.println("2.给指定学生增加多个课程.");
			ss.addCourse("1",new int[] {1,2,3});
			System.out.println("3.取得指定学生的选修课程列表");
			for(CourseModel list:ss.getCourseListByStudent("1")) {
				System.out.println(list.getName());
			}
			System.out.println("4.取得没有被选修的课程列表。");
			for(CourseModel list:ss.getCourseListWithoutSelected()) {
				System.out.println(list.getName());
			}
			System.out.println("5.取得指定同学的选修课程个数:"+ss.getCourseNumByStudent("1"));
			System.out.println("6.取得选修指定课程的学生人数。"+ss.getStudentNumByCourse(1));
			System.out.println("7.取得没有选修任何课程的学生列表。");
			for(StudentModel list:ss.getStudentListWithoutCourse()) {
				System.out.println(list.getName());
			}
			System.out.println("8.取得选修指定课程的学生的平均年龄:"+ss.getStudentAvgAgeBySelectedCourse(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
