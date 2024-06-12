package com.four.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.four.order.bean.OrderBean;
import com.four.order.bean.OrderDetailBean;
import com.four.products.bean.Product;
import com.four.util.ConnectionPool;



//DAO測試
public class OrderDAO  {
	//sql指令
	//======================================================
	String sqlSelectOne = "Select * from orders Where orderID=? ORDER BY orderID DESC";
	String sqlSelectAll_forpage = """
			SELECT * 
				FROM (
					SELECT ROW_NUMBER() OVER (ORDER BY orderID DESC) AS RowNum, *
					FROM orders
					WHERE orderStatus != 'Cancel'
					 ) AS subquery
				WHERE RowNum > ? AND RowNum <= ?;
			""";
	String sqlSelectAll_forpageCount= "Select count(*) as total from orders Where orderStatus != 'Cancel'";
	String sqlSelectAllOrder = "Select * from orders order by orderID Desc;";
	String sqlSelectSpecialOrder = "Select * from orders where orderID like? order by orderID Desc;;";
	
	//Update delete
	String sqlUpdateOrderStatus = "UPDATE orders SET orderStatus=? WHERE orderID=?";
	
	//Select => orderdetails
	String sqlSelectTheOrderDetail = "Select * from orderdetail Where orderID=?";
	//====================================新增==========================================
	//insert
	String sqlInsertOrder = "INSERT INTO orders (OrderID, MemberID, Total, OrderStatus) VALUES(?,?,?,?);"; 
	String sqlInsertOrderDetail = "Insert into orderdetail(OrderID, ProductID, ProductName, OrderDate, Quantity, UnitPrice) VALUES(?,?,?,?,?,?)";
	//======================================================
	/*protected Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/orderdb");
			connection = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}*/
	
	//查詢所有訂單明細
	public List<OrderDetailBean> getAllOrderDetail(String orderID) {
		Connection connection = ConnectionPool.getConnection();
		List<OrderDetailBean> orderdetails = new ArrayList<OrderDetailBean>();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			//thinking
			preparedStatement = connection.prepareStatement(sqlSelectTheOrderDetail);
			preparedStatement.setString(1, orderID);
			//System.out.println("這裡是OrderDAO裡面" + orderID);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				OrderDetailBean orderdetail = new OrderDetailBean();
				orderdetail.setOrderID(orderID);//1
				orderdetail.setProductID(rs.getInt(2));
				/*	看起來
					orderdetail.setOrderID(0);
					string int string localdate int int
				*/
				orderdetail.setProductName(rs.getString(3));
				Timestamp timestamp =rs.getTimestamp("orderDate");
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				orderdetail.setOrderDate(localDateTime);
				orderdetail.setQuantity(rs.getInt(5));
				orderdetail.setUnitPrice(rs.getInt(6));
				orderdetails.add(orderdetail);
			}
			//不能return這裡=> trybox裡面會有生命周期的問題
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(connection,preparedStatement, rs);
		}
		return orderdetails;
	}
	//查詢所有訂單 (模糊查詢)	 public type name param
	public List<OrderBean> getSomeOrder(String orderID){
		List<OrderBean> list = new ArrayList<OrderBean>();
		//這邊是橋
		Connection connection = ConnectionPool.getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqlSelectSpecialOrder);
			//preparedStatement.setString(1, "%"+search+"%");
			preparedStatement.setString(1, "%"+orderID+"%");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				//String int int String
				OrderBean order = new OrderBean();
				order.setOrderID(rs.getString(1));
				order.setMemberID(rs.getInt(2));
				order.setTotal(rs.getInt(3));
				order.setOrderStatus(rs.getString(4));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(connection, preparedStatement, rs);
		}
		return list;
	}
	//查詢單筆訂單
	public OrderBean editOrder(String orderID) {
		//System.out.println("進入修改資料DAO");
		OrderBean order = new OrderBean();
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(sqlSelectOne);
			preparedStatement.setString(1, orderID);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				order.setOrderID(rs.getString(1));
				//System.out.println(rs.getString(1));
				order.setMemberID(rs.getInt(2));
				//System.out.println(rs.getInt(2));
				order.setTotal(rs.getInt(3));
				//System.out.println(rs.getInt(3));
				order.setOrderStatus(rs.getString(4));
				//System.out.println(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, preparedStatement, rs);
		}
		return order;
	}
	public void updateOrderStatus(String orderID, String orderStatus) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			//String sqlUpdateOrderStatus = "UPDATE orders SET orderStatus=? WHERE orderID=?";
			preparedStatement = connection.prepareStatement(sqlUpdateOrderStatus);
			preparedStatement.setString(1, orderStatus);
			preparedStatement.setString(2, orderID);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(connection, preparedStatement);
		}
	}
	//==新增==
	public void insertOrder(String orderID, int member, int total) {
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		//Result rs = null; => insert 不用rs
		try {
			preparedStatement = connection.prepareStatement(sqlInsertOrder);
			preparedStatement.setString(1, orderID);
			preparedStatement.setInt(2, member);
			preparedStatement.setInt(3, total);
			preparedStatement.setString(4, "Pending");
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(connection, preparedStatement);
		}
	}
	//想一下單筆、多筆會不會出錯
	/*[101, Product [productID=101, categoryName=健身配件, productName=健身腰帶, price=8000, listingDate=2024-04-21, 
	 stock=50, productFeatures=超棒腰帶], null, 2, 16000]*/
	public void insertOrderDetail(String orderID ,List<List<Object>> cart) {
		LocalDateTime now = LocalDateTime.now();
		//new 0531
        // 定義輸出格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化日期時間
        String formattedDate = now.format(formatter);
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
//"Insert into orderdetail(OrderID, ProductID, ProductName, OrderDate, Quantity, UnitPrice) VALUES(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sqlInsertOrderDetail);
			for(List<Object> product : cart) {
				Product product1 = new Product();
				product1 = (Product) product.get(1);
				int number = (int) product.get(3);
//	            System.out.println("這是總價");
//	            System.out.println(product.get(4));
	            int small = (int) product.get(4);
	            preparedStatement.setString(1, orderID);
                preparedStatement.setInt(2, product1.getProductID());
                preparedStatement.setString(3, product1.getProductName());
                preparedStatement.setObject(4, formattedDate);
                preparedStatement.setInt(5, number);
                preparedStatement.setInt(6, small);
                preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(connection, preparedStatement, rs);
		}
	}
	
	
	
}