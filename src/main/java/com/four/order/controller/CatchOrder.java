package com.four.order.controller;

import java.io.IOException;
import java.sql.Connection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import com.four.order.dao.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CatchOrder")
public class CatchOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CatchOrder() {
        super();
    }
    Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//0603新增時間 =>秒數
		 LocalTime localTime = LocalTime.now();
		 int sec = localTime.getSecond();
	     String formattedSecond = (sec < 10) ? "0" + sec : String.valueOf(sec);
	     //System.out.println(formattedSecond);
		//創建session object
		HttpSession session = request.getSession();
		LocalDate time = LocalDate.now();
		int year = time.getYear() % 100;
        int month = time.getMonthValue();
        int day = time.getDayOfMonth();
      //===================================================
        String formattedMonth = String.format("%02d", month);
        String formattedDay = String.format("%02d", day);
      //===================================================
		//要接住Session
		String memberNo =  (String) session.getAttribute("memberNo");
		int total = (int) session.getAttribute("totalOrderPrice");
		int member =Integer.valueOf(memberNo);

		// 獲取 session ID => 切割前四碼 24 0529  + 4碼
        String sessionId = session.getId();
		String wantedSession =sessionId.substring(0, 2); //先兩碼session
		String ID = year + formattedMonth + formattedDay + formattedSecond +wantedSession; //24 0603 56  AB
		
		
		//====新增
		List<List<Object>> cart = (List<List<Object>>) session.getAttribute("cart");
		OrderDAO DAO = new OrderDAO();
		DAO.insertOrder(ID, member, total);
		DAO.insertOrderDetail(ID, cart);
		//清空Session
		session.removeAttribute("cart");
		//給Sucess ID
		request.setAttribute("orderID", ID);
		request.getRequestDispatcher("/four/products/jsp/mall/PurchaseSuccess.jsp").forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



