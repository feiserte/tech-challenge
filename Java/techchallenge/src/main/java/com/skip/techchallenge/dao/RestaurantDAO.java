package com.skip.techchallenge.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skip.techchallenge.model.RestaurantDTO;

/************************************************************************************
 * Objective: Data Transfer Object class to manage restaurant data from database
 * @author feiserte
 ************************************************************************************/
public class RestaurantDAO {

	/************************************************************************************
	 * Objective: Select all restaurants from the database.
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com)
	 * @return list of restaurants
	 * @throws SQLException
	 ************************************************************************************/
	public List<RestaurantDTO> getRestaurants() throws SQLException {
		List<RestaurantDTO> restaurantList = new ArrayList<RestaurantDTO>();
		ResultSet rs = MySQLConnection.getDbCon().query("select * from restaurant");
		
		while(rs.next()) {
			RestaurantDTO restaurant = new RestaurantDTO();
			restaurant.setRestaurantId(rs.getInt("restaurantID"));
			restaurant.setName(rs.getString("name"));
			restaurant.setDescription(rs.getString("description"));
			restaurant.setAddress(rs.getString("address"));
			restaurant.setLagitude(rs.getDouble("lagitude"));
			restaurant.setLongitude(rs.getDouble("longitude"));
			
			restaurantList.add(restaurant);
		}
		
		return restaurantList;
	}
}
