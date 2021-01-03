package com.sap.erp.inventory.action;

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

import com.sap.erp.inventory.factory.ServiceFactory;
import com.sap.erp.inventory.model.ProductModel;
import com.sap.erp.inventory.service.IProductService;

/**
 * 部门增加后处理控制器
 */
@WebServlet("/product/add.do")
public class ProductAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date=format1.parse(request.getParameter("date").replace("T", " ")+":00");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Double price=Double.valueOf(request.getParameter("price"));
		Double qty=Double.valueOf(request.getParameter("qty"));
		//封装Model对象
		ProductModel pm=new ProductModel();
		pm.setCode(code);
		pm.setName(name);
		pm.setDate(date);
		pm.setPrice(price);
		pm.setQty(qty);
		
		//取得业务层对象
		IProductService ps=ServiceFactory.createProductservice();
		try {
			ps.add(pm);
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
