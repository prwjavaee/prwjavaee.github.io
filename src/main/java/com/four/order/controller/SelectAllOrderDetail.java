package com.four.order.controller;

import java.io.IOException;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;



import com.four.order.bean.OrderDetailBean;
import com.four.order.dao.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SelectAllOrderDetail")
public class SelectAllOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAllOrderDetail() {
        super();
    }
    Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		OrderDAO DAO = new OrderDAO();
		//要接住JSP 傳過來的request
		String orderID = request.getParameter("orderID");
		List<OrderDetailBean> orderDetails = new ArrayList<>();
		//OrderDetailBean detail = new OrderDetailBean();
		orderDetails = DAO.getAllOrderDetail(orderID);
		request.setAttribute("orderDetail", orderDetails);
		try {
			request.getRequestDispatcher("/four/order/jsp/GetAllOrderDetailEL.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
