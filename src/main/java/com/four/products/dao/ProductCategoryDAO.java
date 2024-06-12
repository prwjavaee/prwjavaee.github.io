package com.four.products.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.four.products.bean.ProductCategory;
import com.four.util.ConnectionPool;

public class ProductCategoryDAO implements DAO<ProductCategory> {

	private static final String SQL_CATEGORY_SEARCHALL = "SELECT * FROM productcategory";
	private static final String SQL_CATEGORY_INSERT = "INSERT INTO productcategory(categoryName) VALUES(?)";
	private static final String SQL_SEARCH_BY_NAME = "SELECT categoryID FROM productcategory WHERE categoryName = ?";

	@Override
	public ProductCategory singleSearch(int categoryID) {
		return null;
	}

	@Override
	public List<ProductCategory> searchAll() {
		List<ProductCategory> categories = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_CATEGORY_SEARCHALL);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int categoryID = resultSet.getInt(1);
				String categorName = resultSet.getString(2);
				ProductCategory category = new ProductCategory(categoryID, categorName);
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean insert(ProductCategory category) {
		int judge = 0;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_CATEGORY_INSERT)) {
			preparedStatement.setString(1, category.getCategoryName());
			judge = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge > 0 ? true : false;
	}

	@Override
	public boolean update(ProductCategory obj) {
		return true;
	}

	@Override
	public boolean delete(List<Integer> id) {
		return true;
	}

	public static int searchCategoryByName(String categoryName) {
		int categoryID = 0;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SEARCH_BY_NAME)) {
			preparedStatement.setString(1, categoryName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				categoryID = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categoryID;
	}

	@Override
	public List<ProductCategory> fuzzySearch(String keyword) {
		return null;
	}

}
