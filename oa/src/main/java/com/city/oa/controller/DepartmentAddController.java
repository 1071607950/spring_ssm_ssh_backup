package com.city.oa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.oa.model.DepartmentModel;
import com.city.oa.service.IDepartmentService;
import com.city.oa.service.impl.DepartmentServiceImplWithHibernate;

/**
 * 部门增加后处理控制器
 */
@WebServlet("/department/add.do")
public class DepartmentAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		//封装Model对象
		DepartmentModel dm=new DepartmentModel();
		dm.setCode(code);
		dm.setName(name);
		//取得业务层对象
		IDepartmentService ds=new DepartmentServiceImplWithHibernate();
		try {
			ds.add(dm);
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
