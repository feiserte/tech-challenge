package com.skip.techchallenge.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skip.techchallenge.model.OrderDTO;

/************************************************************************************
 * Objective: Data Transfer Object class to manage Order data from database
 * @author feiserte
 ************************************************************************************/
public class OrderDAO {

	/************************************************************************************
	 * Objective: Insert order into the database
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return orderId
	 * @throws SQLException
	 ************************************************************************************/
	public Integer insertOrder(OrderDTO order) throws SQLException {
		String sql = "INSERT INTO FoodOrder (orderDate, customerId, deliveryAddress, contact, restaurantId, total, status, lastUpdate) VALUES (?,?,?,?,?,?,?,?)";
				
		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement(sql);
		statement.setString(1, order.getOrderDate());
		statement.setInt(2, order.getCustomerId());
		statement.setString(3, order.getDeliveryAddress());
		statement.setString(4, order.getContact());
		statement.setInt(5, order.getRestaurantId());
		statement.setDouble(6, order.getTotal());
		statement.setString(7, order.getStatus());
		statement.setString(8, order.getLastUpdate());
		
		int result = statement.executeUpdate();
		
		return result;
	}
	
	/************************************************************************************
	 * Objective: Update order into the database
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return orderId
	 * @throws SQLException
	 ************************************************************************************/
	public Integer updateOrder(OrderDTO order) throws SQLException {
		String sql = "UPDATE FoodOrder SET status = ?, lastUpdate = ? WHERE orderId = ?";
				
		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement(sql);
		statement.setString(1, order.getStatus());
		statement.setString(2, order.getLastUpdate());
		statement.setInt(3, order.getId());
		
		int result = statement.executeUpdate();
		
		return result;
	}
	
	/************************************************************************************
	 * Objective: Get order status from the database
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return orderId
	 * @throws SQLException
	 ************************************************************************************/
	public String getOrderStatus(Integer orderId) throws SQLException {
		String status = null;
		String sql = "SELECT STATUS FROM FoodOrder WHERE orderId = ?";
				
		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement(sql);
		statement.setInt(1, orderId);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			status = rs.getString("status");
        }
		
		return status;
	}
}
