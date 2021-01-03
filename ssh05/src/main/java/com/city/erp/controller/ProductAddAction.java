package com.city.erp.controller;

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

import com.city.erp.model.PackagingModel;
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
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = format1.parse(request.getParameter("date"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Double price=Double.valueOf(request.getParameter("price"));
		int qty=Integer.valueOf(request.getParameter("qty"));
		String type=request.getParameter("type");
		int size=Integer.valueOf(request.getParameter("size"));
		String[] areas=request.getParameterValues("areas");
		int[] areaNos= new int[areas.length];
		for(int i=0;i<areas.length;i++) {
			areaNos[i]=Integer.valueOf(areas[i]);
		}
		//封装Model对象
		PackagingModel pkm=new PackagingModel();
		pkm.setType(type);
		pkm.setSize(size);
		ProductModel pm=new ProductModel();
		pm.setName(name);
		pm.setDate(date);
		pm.setPrice(price);
		pm.setQty(qty);
		pm.setPackaging(pkm);
		pkm.setProduct(pm);
		
		//取得业务层对象
		IProductService ps=new ProductServiceImpl();
		try {
			int pno=ps.add(pm);
			System.out.println(areaNos.length);
			if(areaNos.length==1) {
				ps.addArea(pno, areaNos[0]);
				System.out.println("增加一个区域运行");
			}else if(areaNos.length>1) {
				ps.addAreas(pno, areaNos);
				System.out.println("增加多个区域运行");
			}
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
