package com.four.order.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


import com.four.order.dao.OrderDAO;

@WebServlet("/UpdateOrderStatus")
public class UpdateOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOrderStatus() {
        super();
    }
//	===========  注意測試從這裡開始執行=================
    Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("有進入UpdateOrderStatus");
		OrderDAO DAO = new OrderDAO();
		//要接住JSP 傳過來的request
		String orderID = request.getParameter("orderID");
		String orderStatus = request.getParameter("orderStatus");
		DAO.updateOrderStatus(orderID, orderStatus);
//			request.getRequestDispatcher("/GetAllOrderEL").forward(request, response);
		try {
			request.getRequestDispatcher("/GetAllOrder_forpage").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
