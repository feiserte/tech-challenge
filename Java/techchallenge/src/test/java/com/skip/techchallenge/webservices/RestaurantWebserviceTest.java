package com.skip.techchallenge.webservices;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.RestaurantDTO;


public class RestaurantWebserviceTest {

	private RestaurantWebservice ws = new RestaurantWebservice();
	
	@Test
    public void getProductsFromRestaurant() {
		Double userLatitude = -23.533773; 
		Double userLongitude = -46.625290;
		Iterable<RestaurantDTO> restaurants = ws.getRestaurant(userLatitude, userLongitude);

		Assert.assertNotNull(restaurants);
	}
}
