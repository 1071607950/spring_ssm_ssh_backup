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
 * Servlet implementation class DepartmentToViewController
 */
@WebServlet("/department/toview.do")
public class DepartmentToViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentToViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno=request.getParameter("no");
		IDepartmentService ds=new DepartmentServiceImplWithHibernate();
		int no=1;
		if(sno!=null) {
			no=Integer.parseInt(sno);
		}
		try {
			DepartmentModel dm = ds.getByNo(no);
			request.setAttribute("dm", dm);
			request.getRequestDispatcher("view.jsp").forward(request, response);
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
