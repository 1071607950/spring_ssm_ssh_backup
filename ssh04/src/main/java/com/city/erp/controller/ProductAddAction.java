package com.city.erp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.erp.model.CategoryModel;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
import com.city.erp.service.impl.ProductServiceImpl;

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
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		int qty=Integer.valueOf(request.getParameter("qty"));
		int gno=Integer.valueOf(request.getParameter("gno"));
		//封装Model对象
		ProductModel pm=new ProductModel();
		pm.setName(name);
		pm.setPrice(price);
		pm.setQty(qty);
		CategoryModel cm=new CategoryModel();
		cm.setNo(gno);
		pm.setCategory(cm);
		//取得业务层对象
		IProductService ps=new ProductServiceImpl();
		try {
			ps.add(pm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("toadd.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
