package com.city.oaapp.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oaapp.model.EmployeeModel;
import com.city.oaapp.service.IEmployeeService;
import com.city.oaapp.service.impl.EmployeeServiceImpl;

/**
 * 部门增加后处理控制器
 */
@WebServlet("/employee/add.do")
public class EmployeeAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday=format1.parse(request.getParameter("birthday"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int age=Integer.valueOf(request.getParameter("age"));
		Double salary=Double.valueOf(request.getParameter("salary"));
		//封装Model对象
		EmployeeModel em=new EmployeeModel();
		em.setId(id);
		em.setName(name);
		em.setSex(sex);
		em.setBirthday(birthday);
		em.setAge(age);
		em.setSalary(salary);
		//取得业务层对象
		IEmployeeService es=new EmployeeServiceImpl();
		try {
			es.add(em);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("add.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
