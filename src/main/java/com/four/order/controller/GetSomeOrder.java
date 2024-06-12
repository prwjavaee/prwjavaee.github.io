package com.four.order.controller;
import java.io.IOException;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;



import com.four.order.bean.OrderBean;
import com.four.order.dao.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetSomeOrder")
public class GetSomeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetSomeOrder() {
        super();
    }
//	===========  模糊查詢=================
    Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<OrderBean> list = new ArrayList<OrderBean>();
//		System.out.println("有進來GetSomeOrder");
		String search = request.getParameter("search");
		OrderDAO DAO = new OrderDAO();
		list = DAO.getSomeOrder(search);
		request.setAttribute("orders", list);
		//request.getRequestDispatcher("/four/jsp/order/GetAllOrder_forpage.jsp").forward(request, response);
		try {
			request.getRequestDispatcher("/four/order/jsp/GetAllOrderEL.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
