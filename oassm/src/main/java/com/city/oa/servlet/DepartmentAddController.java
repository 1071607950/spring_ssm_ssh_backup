package com.city.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;

/**
 * Servlet implementation class DepartmentAddController
 */
@WebServlet("/DepartmentAddController")
public class DepartmentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationcontextforssm.xml");
		IDepartmentService ds=ac.getBean("DepartmentServiceWithSSM",IDepartmentService.class);
		
		try {
			DepartmentModel dm=ds.getByNoWithEmployees(1);
			System.out.println(dm.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
