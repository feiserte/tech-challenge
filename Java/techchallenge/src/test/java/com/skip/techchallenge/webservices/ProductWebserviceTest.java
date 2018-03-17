package com.skip.techchallenge.webservices;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.ProductDTO;

public class ProductWebserviceTest {

	private ProductWebservice ws = new ProductWebservice();
	
	@Test
    public void getProductsFromRestaurant() {
		Integer restaurantId = 1;
		
		Iterable<ProductDTO> products = ws.getProductsFromRestaurant(restaurantId);

		Assert.assertNotNull(products);
	}
}
