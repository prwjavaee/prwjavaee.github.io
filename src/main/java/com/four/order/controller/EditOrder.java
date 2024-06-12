package com.four.order.controller;

import java.io.IOException;

import com.four.order.bean.OrderBean;
import com.four.order.dao.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditOrder")
public class EditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditOrder() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		OrderDAO DAO = new OrderDAO();
		//要接住JSP 傳過來的request
		String orderID = request.getParameter("orderID");
		OrderBean order = new OrderBean();
		order = DAO.editOrder(orderID);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/four/order/jsp/GetOneOrderEL.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
