package com.four.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.four.food.bean.FoodBean;
import com.four.util.ConnectionPool;

public class FoodDao {

	// 新增
	public void insert(FoodBean foodBean) {
		String sql = "INSERT INTO food(foodID,foodName,protein,carbohydrates,fat,totalCaloriesPer100g)"
				+ " Values(?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = ConnectionPool.getConnection();

			// 執行查詢取最大的 foodID
			String maxIDQuery = "SELECT MAX(foodID) FROM food;";
			PreparedStatement maxIDStmt = connection.prepareStatement(maxIDQuery);
			rs = maxIDStmt.executeQuery();
			int nextFoodID = 1; // 如果找不到記錄，則默認值為1
			if (rs.next()) {
				int maxID = rs.getInt(1);
				nextFoodID = maxID + 1;
			}
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, nextFoodID);// 使用從資料庫中獲取的下一個 foodID
			stmt.setString(2, foodBean.getFoodName());
			stmt.setFloat(3, foodBean.getProtein());
			stmt.setFloat(4, foodBean.getCarbohydrates());
			stmt.setFloat(5, foodBean.getFat());
			stmt.setFloat(6, foodBean.getTotalCaloriesPer100g());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(connection, stmt, rs);
		}
	}

	// 刪除byName
	public void deleteByName(String foodName) {
		String sql = "DELETE FROM food WHERE foodName = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionPool.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, foodName);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				ConnectionPool.closeResource(conn, stmt);
		}
	}
	//刪除byID
	public void deleteByID(int foodID) {
		String sql = "DELETE FROM food WHERE foodID = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionPool.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, foodID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				ConnectionPool.closeResource(conn, stmt);
		}
	}
	

	// 更新
	public void updateByFoodID(FoodBean foodBean) {
		String sql = "UPDATE food SET foodName=?, protein=?, carbohydrates=?, fat=?, totalCaloriesPer100g=? WHERE foodID=?;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, foodBean.getFoodName());
			stmt.setFloat(2, foodBean.getProtein());
			stmt.setFloat(3, foodBean.getCarbohydrates());
			stmt.setFloat(4, foodBean.getFat());
			stmt.setFloat(5, foodBean.getTotalCaloriesPer100g());
			stmt.setInt(6, foodBean.getFoodID());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionPool.closeResource(conn, stmt);
		}
	}

	// 查詢byName
	public List<FoodBean> queryByFoodName(String foodName) {
		List<FoodBean> foods = new ArrayList<>();
		String sql = "SELECT * FROM food WHERE foodName LIKE ?;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		FoodBean food = null;
		try {
			stmt = conn.prepareStatement(sql);
			// % 萬用字元
			stmt.setString(1, "%" + foodName + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				food = new FoodBean();
				food.setFoodName(rs.getString("foodName"));
				food.setProtein(rs.getFloat("protein"));
				food.setCarbohydrates(rs.getFloat("carbohydrates"));
				food.setFat(rs.getFloat("fat"));
				food.setTotalCaloriesPer100g(rs.getFloat("totalCaloriesPer100g"));
				foods.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return foods;
	}

	// 查詢byID
	public FoodBean queryByFoodID(int foodID) {
		String sql = "SELECT * FROM food WHERE foodID = ?";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		FoodBean food = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, foodID);
			rs = stmt.executeQuery();

			if (rs.next()) {
				food = new FoodBean();
				food.setFoodID(rs.getInt("foodID"));
				food.setFoodName(rs.getString("foodName"));
				food.setProtein(rs.getFloat("protein"));
				food.setCarbohydrates(rs.getFloat("carbohydrates"));
				food.setFat(rs.getFloat("fat"));
				food.setTotalCaloriesPer100g(rs.getFloat("totalCaloriesPer100g"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return food;
	}

	// 查整張表
	public List<FoodBean> queryAll() {
		String sql = "SELECT * FROM food;";
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<FoodBean> foods = new ArrayList<>();
		FoodBean food = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				food = new FoodBean();
				food.setFoodID(rs.getInt("foodID"));
				food.setFoodName(rs.getString("foodName"));
				food.setProtein(rs.getFloat("protein"));
				food.setCarbohydrates(rs.getFloat("carbohydrates"));
				food.setFat(rs.getFloat("fat"));
				food.setTotalCaloriesPer100g(rs.getFloat("totalCaloriesPer100g"));
				foods.add(food);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.closeResource(conn, stmt, rs);
		}
		return foods;
	}
}
