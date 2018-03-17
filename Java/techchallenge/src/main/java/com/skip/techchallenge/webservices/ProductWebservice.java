package com.skip.techchallenge.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.techchallenge.business.RestaurantBO;
import com.skip.techchallenge.model.ProductDTO;

/************************************************************************************
 * Objective: Webservice to get product information
 * @author feiserte
 ************************************************************************************/
@RestController
public class ProductWebservice {
	
	@RequestMapping("/getProducts")
	public @ResponseBody Iterable<ProductDTO> getProductsFromRestaurant(@RequestParam(value="restaurantId", defaultValue="") Integer restaurantId) {
		RestaurantBO bo = new RestaurantBO();
		
		return bo.getProductsByRestaurant(restaurantId);
	}
	
}
