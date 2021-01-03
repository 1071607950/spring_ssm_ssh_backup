package com.city.sales.test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.city.sales.config.SpringConfig;
import com.city.sales.model.OrderModel;
import com.city.sales.service.IOrderService;


@WebServlet("/add.do")
public class testserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testserver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		IOrderService os=ac.getBean("OrderService",IOrderService.class);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		OrderModel om=new OrderModel();
		om.setName("苹果");
		om.setPrice(1);
		om.setQty(10);
		try {
			om.setDate(sdf.parse("2020-01-01"));
			os.add(om);
			
			for(OrderModel list:os.getListBySearchName("苹果")) {
				System.out.println("编号:"+list.getNo()+",名称:"+list.getName());
			}
			
			System.out.println("时间内的产品总金额:"+os.getAmountByDateScope(sdf.parse("2019-01-01"), sdf.parse("2019-12-31")));
			
			for(OrderModel list:os.getListByPriceScope(1, 2)) {
				System.out.println("编号:"+list.getNo()+"单价:"+list.getPrice());
			}
			
			System.out.println("总个数:"+os.getCountByPriceScope(1, 2));
			System.out.println("指定产品总金额:"+os.getAmountByProduct("苹果"));
			
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
