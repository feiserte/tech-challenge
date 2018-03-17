package com.skip.techchallenge.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.ProductDTO;

public class ProductDAOTest {

	private ProductDAO dao = new ProductDAO(); 
	
	@Test
	public void getUserByEmail() throws SQLException {
		Integer restaurantId = 1;
		List<ProductDTO> productList = dao.getProductsByRestaurant(restaurantId);
		
		Assert.assertNotNull(productList);
	}
}
