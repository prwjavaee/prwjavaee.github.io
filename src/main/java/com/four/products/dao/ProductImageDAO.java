package com.four.products.dao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.four.products.bean.ProductImage;
import com.four.util.ConnectionPool;

public class ProductImageDAO implements DAO<ProductImage> {

	private static final String SQL_SEARCH_ALL_IMAGE_STRING = "SELECT * FROM productimage";
	private static final String SQL_SEARCH_SELECTED_PRODUCT_IMAGES = "select * from productimage where productID = ?";
	private static final String SQL_INSERT_IMAGES = "INSERT INTO productimage(imageID, productID, productImage) VALUES(?, ?, ?)";
	private static final String SQL_GET_MAXIMAGEID = "SELECT TOP 1 imageID FROM productimage WHERE productID = ? ORDER BY imageID desc";
	private static final String SQL_DELETE = "DELETE FROM productimage WHERE productID IN(";
	private static final String SQL_INIT = "INSERT INTO productimage VALUES (1, ?, ?)";

	public List<ProductImage> searchProductImages(int selectedID) {
		List<ProductImage> images = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SEARCH_SELECTED_PRODUCT_IMAGES);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			preparedStatement.setInt(1, selectedID);
			while (resultSet.next()) {
				int imageID = resultSet.getInt(1);
				int producID = resultSet.getInt(2);
				byte[] image = resultSet.getBytes(3);
				ProductImage imageData = new ProductImage(imageID, producID, image);
				images.add(imageData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return images;
	}

	@Override
	public List<ProductImage> searchAll() {
		List<ProductImage> allImages = new ArrayList<>();
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SEARCH_ALL_IMAGE_STRING);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				int imageID = resultSet.getInt(1);
				int producID = resultSet.getInt(2);
				byte[] image = resultSet.getBytes(3);
				ProductImage images = new ProductImage(imageID, producID, image);
				allImages.add(images);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allImages;
	}

	@Override
	public boolean insert(ProductImage image) {
		int judge = 0;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_IMAGES)) {
			preparedStatement.setInt(1, image.getImageID());
			preparedStatement.setInt(2, image.getProductID());
			preparedStatement.setBytes(3, image.getImage());
			judge = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge > 0 ? true : false;
	}

	@Override
	public boolean update(ProductImage obj) {
		return true;
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

	@Override
	public ProductImage singleSearch(int selectedID) {
		ProductImage imageData = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_SEARCH_SELECTED_PRODUCT_IMAGES)) {
			preparedStatement.setInt(1, selectedID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int imageID = resultSet.getInt(1);
				int producID = resultSet.getInt(2);
				byte[] image = resultSet.getBytes(3);
				imageData = new ProductImage(imageID, producID, image);
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
		return imageData;
	}
	
	@Override
	public List<ProductImage> fuzzySearch(String keyword) {
		return null;
	}

	public int getMaxImageID(int productID) {
		int maxImageID = 1;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_MAXIMAGEID)) {
			preparedStatement.setInt(1, productID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				maxImageID = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxImageID;
	}

	public static void initInsert(String imagePath, int productID) {
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INIT);
				InputStream fis = new BufferedInputStream(new FileInputStream(imagePath))) {
			preparedStatement.setInt(1, productID);
			preparedStatement.setBinaryStream(2, fis);
			preparedStatement.execute();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean check() {
		String sql = "SELECT COUNT(*) FROM productimage";
		boolean hasData = false;
		try (Connection connection = ConnectionPool.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {
			if(resultSet.next()) {
				hasData = (resultSet.getInt(1) > 0) ? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hasData;
	}

}
