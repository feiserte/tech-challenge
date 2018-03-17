package com.skip.techchallenge.dao;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.OrderDTO;

public class OrderDAOTest {

	private OrderDAO dao = new OrderDAO(); 
	
	@Test
	public void insertOrder() throws SQLException {
		OrderDTO order = new OrderDTO();
		
		dao.insertOrder(order);
		
		Assert.assertNotNull(order);
		Assert.assertEquals((Double)24.990000000000002, order.getTotal());
	}
	
	@Test
	public void cancelOrder() throws SQLException {
		OrderDTO order = new OrderDTO();
		order.setId(3);
		
		Integer result = dao.updateOrder(order);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(new Integer(1), result);
	}
	
	@Test
	public void getOrderStatus() throws SQLException {
		Integer orderId = 3;
		
		String status = dao.getOrderStatus(orderId);
		
		Assert.assertNotNull(status);
	}
}
