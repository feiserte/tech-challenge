package com.skip.techchallenge.webservices;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.techchallenge.business.OrderBO;
import com.skip.techchallenge.model.OrderDTO;
import com.skip.techchallenge.model.ProductDTO;

/************************************************************************************
 * Objective: Webservice to create / get status / cancel orders.
 * @author feiserte
 ************************************************************************************/
@RestController
public class OrderWebservice {
	
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public @ResponseBody OrderDTO createOrder(@RequestParam(value="customerId") Integer customerId, @RequestBody List<ProductDTO> productList) {
		OrderBO bo = new OrderBO();
		
		return bo.createOrder(customerId, productList);
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
