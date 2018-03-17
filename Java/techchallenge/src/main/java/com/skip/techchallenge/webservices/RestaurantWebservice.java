package com.skip.techchallenge.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.techchallenge.business.RestaurantBO;
import com.skip.techchallenge.model.RestaurantDTO;

/************************************************************************************
 * Objective: Webservice to get restaurant information
 * @author feiserte
 ************************************************************************************/
@RestController
public class RestaurantWebservice {
	
	@RequestMapping("/getRestaurants")
	public @ResponseBody Iterable<RestaurantDTO> getRestaurant(@RequestParam(value="userLatitude", defaultValue="-23.533773") Double userLatitude, @RequestParam(value="userLongitude", defaultValue="-46.625290") Double userLongitude) {
		RestaurantBO bo = new RestaurantBO();
		
		return bo.getRestaurants(userLatitude, userLongitude);
	}
	
}
