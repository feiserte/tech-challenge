package com.skip.techchallenge.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.skip.techchallenge.dao.ProductDAO;
import com.skip.techchallenge.dao.RestaurantDAO;
import com.skip.techchallenge.model.ProductDTO;
import com.skip.techchallenge.model.RestaurantDTO;

/************************************************************************************
 * Objective: Business object class to handle Restaurant interactions.
 * @author feiserte
 ************************************************************************************/
public class RestaurantBO {
	
	private final Logger logger = Logger.getLogger(RestaurantBO.class);
	
	private ProductDAO productDAO = new ProductDAO();
	private RestaurantDAO restaurantDAO = new RestaurantDAO();

	/************************************************************************************
	 * Objective: Get restaurants
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return list of Restaurants
	 ************************************************************************************/
	public List<RestaurantDTO> getRestaurants(double userLatitude, double userLongitude) {
		List<RestaurantDTO> restaurantList = null;
		
		try {
			restaurantList = restaurantDAO.getRestaurants();
		} catch (SQLException e) {
			String errorMsg = "Error trying to get restaurants. Error: " + e.getMessage();
			logger.error(errorMsg, e);
			return null;
		}
		
		return restaurantList;
	}
	
	/************************************************************************************
	 * Objective: Get products by restaurant
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return list of Products
	 ************************************************************************************/
	public List<ProductDTO> getProductsByRestaurant(int restaurantId) {
		List<ProductDTO> productList = null;
		
		try {
			productList = productDAO.getProductsByRestaurant(restaurantId);
		} catch (SQLException e) {
			String errorMsg = "Error trying to get products by restaurant id. Error: " + e.getMessage();
			logger.error(errorMsg, e);
			return null;
		}
		
		return productList;
	}
}
