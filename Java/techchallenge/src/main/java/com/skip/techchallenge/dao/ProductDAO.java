package com.skip.techchallenge.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skip.techchallenge.model.ProductDTO;

/************************************************************************************
 * Objective: Data Transfer Object class to manage Product data from database
 * @author feiserte
 ************************************************************************************/
public class ProductDAO {

	/************************************************************************************
	 * Objective: Get products by restaurantId
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return List of products
	 * @throws SQLException
	 ************************************************************************************/
	public List<ProductDTO> getProductsByRestaurant(int restaurantId) throws SQLException {
		List<ProductDTO> productList = new ArrayList<ProductDTO>();

		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement("select * from products where restaurantID = ?");
		statement.setInt(1, restaurantId);
		ResultSet rs = statement.executeQuery();

		while(rs.next()) {
			ProductDTO product = new ProductDTO();
			product = new ProductDTO();
			product.setProductId(rs.getInt("productId"));
			product.setRestaurantId(rs.getInt("restaurantID"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getDouble("price"));

			productList.add(product);
		}

		return productList;
	}
}
