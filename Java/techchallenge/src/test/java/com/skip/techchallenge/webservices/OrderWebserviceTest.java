package com.skip.techchallenge.webservices;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.skip.techchallenge.model.OrderDTO;
import com.skip.techchallenge.model.ProductDTO;
import com.skip.techchallenge.util.OrderStatusEnum;

public class OrderWebserviceTest {

	private OrderWebservice ws = new OrderWebservice();
	
	@Test
    public void createOrder() {
		Integer customerId = 1;
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		productList.add(new ProductDTO( 
				1,
				1, 
				"Test Name", 
				"Test Description", 
				8.33,
				3
				));
		
		OrderDTO order = ws.createOrder(customerId, productList);

		Assert.assertNotNull(order);
		Assert.assertEquals((Double)24.990000000000002, order.getTotal());
	}
	
	@Test
    public void cancelOrder() {
		Integer orderId = 3;
		
		String status = ws.cancelOrder(orderId);

		Assert.assertEquals(OrderStatusEnum.ORDER_CANCELED.status(), status);
	}
	
	@Test
    public void getOrderStatus() {
		Integer orderId = 3;
		
		String status = ws.getOrderStatus(orderId);

		Assert.assertNotNull(status);
	}
}
