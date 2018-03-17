package com.skip.techchallenge.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.RestaurantDTO;

public class RestaurantDAOTest {

	private RestaurantDAO dao = new RestaurantDAO(); 
	
	@Test
	public void getUserByEmail() throws SQLException {
		List<RestaurantDTO> restaurantList = dao.getRestaurants();
		
		Assert.assertNotNull(restaurantList);
	}
}
