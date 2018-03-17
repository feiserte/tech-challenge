package com.skip.techchallenge.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.OrderDTO;
import com.skip.techchallenge.util.OrderStatusEnum;
import com.skip.techchallenge.util.Util;

public class OrderDAOTest {

	private OrderDAO dao = new OrderDAO(); 
	
	@Test
	public void insertOrder() throws SQLException {
		OrderDTO order = new OrderDTO();
		order.setCustomerId(1);
		order.setDeliveryAddress("Hotel Transamerica");
		order.setStatus(OrderStatusEnum.ORDER_CREATED.status());
		order.setOrderDate(new SimpleDateFormat(Util.ORDER_DATA_FORMAT).format(new Date()));
		order.setRestaurantId(1);
		order.setTotal(new Double(20));
		order.setLastUpdate(new SimpleDateFormat(Util.ORDER_DATA_FORMAT).format(new Date()));
		
		dao.insertOrder(order);
		
		Assert.assertNotNull(order);
		Assert.assertEquals((Double)20.0, order.getTotal());
	}
	
	@Test
	public void cancelOrder() throws SQLException {
		OrderDTO order = new OrderDTO();
		order.setId(3);
		order.setStatus(OrderStatusEnum.ORDER_CANCELED.status());
		order.setLastUpdate(new SimpleDateFormat(Util.ORDER_DATA_FORMAT).format(new Date()));
		
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
