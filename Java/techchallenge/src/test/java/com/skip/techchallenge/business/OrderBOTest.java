package com.skip.techchallenge.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.CustomerDTO;
import com.skip.techchallenge.model.OrderDTO;
import com.skip.techchallenge.model.ProductDTO;

public class OrderBOTest {

	private OrderBO bo = new OrderBO(); 
	
	@Test
	public void createOrder() {
		CustomerDTO user = new CustomerDTO();
		user.setName("Felipe");
		user.setId(1);
		user.setAddress("Rua artur prado 341");
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		productList.add(new ProductDTO( 
				1,
				1, 
				"Test Name", 
				"Test Description", 
				8.33,
				3
				));
		
		OrderDTO order = bo.createOrder(user, productList);
		
		Assert.assertNotNull(order);
		Assert.assertEquals((Double)24.990000000000002, order.getTotal());
	}
	
	@Test
	public void cancelOrder() {
		Integer orderId = 3;
		
		String status = bo.cancelOrder(orderId);
		
		Assert.assertNotNull(status);
	}
	
	@Test
	public void getOrderStatus() {
		Integer orderId = 3;
		
		String status = bo.getOrderStatus(orderId);
		
		Assert.assertNotNull(status);
	}
	 
}
