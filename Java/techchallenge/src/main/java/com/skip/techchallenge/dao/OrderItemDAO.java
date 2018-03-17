package com.skip.techchallenge.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.skip.techchallenge.model.OrderItemDTO;

/************************************************************************************
 * Objective: Data Transfer Object class to manage OrderItem data from database
 * @author feiserte
 ************************************************************************************/
public class OrderItemDAO {

	/************************************************************************************
	 * Objective: Insert order items into the database
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @return orderItemId
	 * @throws SQLException
	 ************************************************************************************/
	public Integer insertOrderItems(OrderItemDTO orderItem) throws SQLException {
		String sql = "INSERT INTO FoodOrderItem (orderId, productId, price, quantity, total) VALUES (?,?,?,?,?)";
				
		PreparedStatement statement = MySQLConnection.getDbCon().conn.prepareStatement(sql);
		statement.setInt(1, orderItem.getOrderId());
		statement.setInt(2, orderItem.getProductId());
		statement.setDouble(3, orderItem.getPrice());
		statement.setInt(4, orderItem.getQuantity());
		statement.setDouble(5, orderItem.getTotal());
		
		int result = statement.executeUpdate();
		
		return result;
	}
}
