package com.skip.techchallenge.webservices;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.techchallenge.business.OrderBO;
import com.skip.techchallenge.model.CustomerDTO;
import com.skip.techchallenge.model.OrderDTO;
import com.skip.techchallenge.model.ProductDTO;

/************************************************************************************
 * Objective: Webservice to create / get status / cancel orders.
 * @author feiserte
 ************************************************************************************/
@RestController
public class OrderWebservice {
	
	@RequestMapping("/createOrder")
	public @ResponseBody OrderDTO createOrder(@RequestParam(value="customer") CustomerDTO customer, @RequestParam(value="productList") List<ProductDTO> productList) {
		OrderBO bo = new OrderBO();
		
		return bo.createOrder(customer, productList);
	}
	
	@RequestMapping("/cancelOrder")
	public @ResponseBody String cancelOrder(@RequestParam(value="orderId") Integer orderId) {
		OrderBO bo = new OrderBO();
		
		return bo.cancelOrder(orderId);
	}
	
	@RequestMapping("/getOrderStatus")
	public @ResponseBody String getOrderStatus(@RequestParam(value="orderId") Integer orderId) {
		OrderBO bo = new OrderBO();
		
		return bo.getOrderStatus(orderId);
	}
	
}
