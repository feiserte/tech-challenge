package com.skip.techchallenge.dao;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.OrderItemDTO;

public class OrderItemDAOTest {

	private OrderItemDAO dao = new OrderItemDAO(); 
	
	@Test
	public void getUserByEmail() throws SQLException {
		OrderItemDTO orderItem = new OrderItemDTO();
		orderItem.setOrderId(3);
		orderItem.setPrice(new Double(20));
		orderItem.setProductId(1);
		orderItem.setQuantity(1);
		orderItem.setTotal(new Double(20));
		
		
		Integer orderId = dao.insertOrderItems(orderItem);
		
		Assert.assertNotNull(orderId);
	}
}
