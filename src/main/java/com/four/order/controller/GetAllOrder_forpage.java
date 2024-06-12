package com.four.order.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.four.order.bean.OrderBean;
import com.four.util.ConnectionPool;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetAllOrder_forpage")
public class GetAllOrder_forpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllOrder_forpage() {
        super();
    }
//	===========  注意測試從這裡開始執行=================
    Connection connection;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		connection = ConnectionPool.getConnection();
		List<OrderBean> list = new ArrayList<OrderBean>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int page = 1;
		int wantedpage = 10;
		//因為他是get傳過來
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		//System.out.println("這裡是page: " + page);
		//String sqlString = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY orderID desc) AS RowNum, * FROM orders) AS orderID WHERE RowNum > ? AND RowNum <= ?";
		
		String query = """
			    SELECT * 
			    FROM (
			        SELECT ROW_NUMBER() OVER (ORDER BY orderID DESC) AS RowNum, *
			        FROM orders
			        WHERE orderStatus != 'Cancel'
			    ) AS subquery
			    WHERE RowNum > ? AND RowNum <= ?;
			    """;
//		String sqlString = "Select * from orders order by orderID desc;";
		//String sqlString2= "Select count(*) as total from orders";
		String query1 = "Select count(*) as total from orders Where orderStatus != 'Cancel'";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, (page-1)*wantedpage );
			preparedStatement.setInt(2, page*wantedpage );
//			System.out.println("準備裝箱");
			//shite alt l
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
//				System.out.println("rs有回來");
				OrderBean order = new OrderBean();
				//System.out.println("準備取物件");
				order.setOrderID(rs.getString(2));
				order.setMemberID(rs.getInt(3));
				order.setTotal(rs.getInt(4));
				order.setOrderStatus(rs.getString(5));
				list.add(order);
			}
			request.setAttribute("orders", list);
			//為什麼這邊要Close => 因為不同trycatchbox所以會memoryLeak
			preparedStatement.close();
			rs.close(); 
			//preparedStatement = connection.prepareStatement(sqlString2);
			preparedStatement = connection.prepareStatement(query1);
			rs = preparedStatement.executeQuery();
			int noOfRecords = 0;
	        if(rs.next()) {
            	//假設取回來是第11筆
                noOfRecords = rs.getInt(1);
                //System.out.println("這裡是總數: " + noOfRecords);
            }
	      //取的總頁面
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / wantedpage);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
			//送request
			request.getRequestDispatcher("/four/order/jsp/GetAllOrder_forpage.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(connection, preparedStatement, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
