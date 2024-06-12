package com.four.products.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.four.products.bean.Product;
import com.four.util.ConnectionPool;

public class ProductDAO implements DAO<Product> {

	private static final String SQL_EXPLORE_PAGE_SEARCHALL = "SELECT * FROM product_view";
	private static final String SQL_SINGLE_SEARCH = "SELECT * FROM product_view WHERE productID = ?";
	private static final String SQL_FIND_LASTDATA = "SELECT TOP 1 productID FROM product ORDER BY productID DESC";
	private static final String SQL_INSERT = "INSERT INTO product(categoryID, productName, price, listingDate, stock, productFeatures) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM product WHERE productID IN(";
	private static final String SQL_UPDATE = "UPDATE product SET categoryID = ?, productName = ?, price = ?, listingDate = ?, stock = ?, productFeatures = ? WHERE productID = ?";
	private static final String SQL_FUZZY_SEARCH = "SELECT * FROM product_view WHERE productName LIKE ? OR categoryName LIKE ?";
	
	@Override
	public Product singleSearch(int selectedID) {
		Product selectedProduct = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SINGLE_SEARCH)) {
			preparedStatement.setInt(1, selectedID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int productID = resultSet.getInt(1);
				String categoryName = resultSet.getString(2);
				String productName = resultSet.getString(3);
				int price = resultSet.getInt(4);
				Date date = resultSet.getDate(5);
				Date listingDate = new Date(date.getTime());
				int stock = resultSet.getInt(6);
				String productFeatureString = resultSet.getString(7);
				selectedProduct = new Product(productID, categoryName, productName, price, listingDate, stock,
						productFeatureString);
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
		return selectedProduct;
	}

	@Override
	public List<Product> searchAll() {
		List<Product> productsList = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXPLORE_PAGE_SEARCHALL);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int productID = resultSet.getInt(1);
				String categoryName = resultSet.getString(2);
				String productName = resultSet.getString(3);
				int price = resultSet.getInt(4);
				Date date = resultSet.getDate(5);
				Date listingDate = new Date(date.getTime());
				int stock = resultSet.getInt(6);
				String productFeatureString = resultSet.getString(7);
				Product product = new Product(productID, categoryName, productName, price, listingDate, stock,
						productFeatureString);
				productsList.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}
	
	@Override
	public List<Product> fuzzySearch(String keyword) {
		List<Product> productSearchResult = new ArrayList<>();
		ResultSet resultSet = null;
		try (Connection connection = ConnectionPool.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SQL_FUZZY_SEARCH)) {
			preparedStatement.setString(1, keyword);
			preparedStatement.setString(2, keyword);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int productID = resultSet.getInt(1);
				String categoryName = resultSet.getString(2);
				String productName = resultSet.getString(3);
				int price = resultSet.getInt(4);
				Date date = resultSet.getDate(5);
				Date listingDate = new Date(date.getTime());
				int stock = resultSet.getInt(6);
				String productFeatureString = resultSet.getString(7);
				Product product = new Product(productID, categoryName, productName, price, listingDate, stock,
						productFeatureString);
				productSearchResult.add(product);
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
		return productSearchResult;
	}

	@Override
	public boolean insert(Product product) {
		int judge = 0;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
			int catergoryID = ProductCategoryDAO.searchCategoryByName(product.getCategoryName());
			preparedStatement.setInt(1, catergoryID);
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setInt(3, product.getPrice());
			Date sqlDate = new Date(product.getListingDate().getTime());
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setInt(5, product.getStock());
			preparedStatement.setString(6, product.getProductFeatures());
			judge = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge > 0 ? true : false;
	}

	@Override
	public boolean update(Product updatedProductInfo) {
		int judge = 0;
		try (Connection connection = ConnectionPool.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
			int categoryID = ProductCategoryDAO.searchCategoryByName(updatedProductInfo.getCategoryName());
			preparedStatement.setInt(1, categoryID);
			preparedStatement.setString(2, updatedProductInfo.getProductName());
			preparedStatement.setInt(3, updatedProductInfo.getPrice());
			Date sqlDate = new Date(updatedProductInfo.getListingDate().getTime());
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setInt(5, updatedProductInfo.getStock());
			preparedStatement.setString(6, updatedProductInfo.getProductFeatures());
			preparedStatement.setInt(7, updatedProductInfo.getProductID());
			judge = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge > 0 ? true : false;
	}

	@Override
	public boolean delete(List<Integer> productIDs) {
		int judge = 0;
		int numberOfData = productIDs.size();
		StringBuilder sqlDelete = new StringBuilder();
		sqlDelete.append(SQL_DELETE);
		for(int i = 0 ; i < numberOfData ; i++) {
			if(i != numberOfData - 1) {sqlDelete.append("?, ");}
			else {sqlDelete.append("?)");}
		}
		try (Connection connection = ConnectionPool.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete.toString())) {
			for(int j = 0 ; j < numberOfData ; j++) {
				preparedStatement.setInt(j+1, productIDs.get(j));
			}
			judge = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge > 0 ? true : false;
	}

	public static int getMaxProductID() {
		int currentMaxID = 0;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_LASTDATA);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				currentMaxID = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentMaxID;
	}
	
}
