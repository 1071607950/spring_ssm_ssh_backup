package com.city.mis.controller;

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

import com.city.mis.model.CustomerModel;
import com.city.mis.service.ICustomerService;
import com.city.mis.service.impl.CustomerServiceImpl;

/**
 * 部门增加后处理控制器
 */
@WebServlet("/customer/process.do")
public class CustomerAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		int num=Integer.valueOf(request.getParameter("num"));
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = format1.parse(request.getParameter("date"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Double yearsales=Double.valueOf(request.getParameter("yearsales"));
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		//封装Model对象
		CustomerModel cm=new CustomerModel();
		cm.setCode(code);
		cm.setName(name);
		cm.setNum(num);
		cm.setDate(date);
		cm.setYearsales(yearsales);
		cm.setAddress(address);
		cm.setTel(tel);
		//取得业务层对象
		ICustomerService cs=new CustomerServiceImpl();
		try {
			if(action.equals("添加")) {
				cs.add(cm);
			}else if(action.equals("修改")) {
				int no=Integer.valueOf(request.getParameter("no"));
				cm.setNo(no);
				cs.modify(cm);
			}
		} catch (Exception e) {
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
