package com.skip.techchallenge.business;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.ProductDTO;
import com.skip.techchallenge.model.RestaurantDTO;

public class RestaurantBOTest {

	private RestaurantBO bo = new RestaurantBO(); 
	
	@Test
    public void getRestaurants() {
		double userLatitude = 23.1;
		double userLongitude = 4.1;
		List<RestaurantDTO> restaurants = bo.getRestaurants(userLatitude, userLongitude);
		
		Assert.assertNotNull(restaurants);
	}
	
	public void getProductsFromRestaurant() {
		int restaurantId = 1;
		List<ProductDTO> products = bo.getProductsByRestaurant(restaurantId);
		
		Assert.assertNotNull(products);
	}
	 
}
