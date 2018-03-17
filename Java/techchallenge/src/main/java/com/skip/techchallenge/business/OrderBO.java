package com.skip.techchallenge.business;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.skip.techchallenge.dao.OrderDAO;
import com.skip.techchallenge.dao.OrderItemDAO;
import com.skip.techchallenge.model.CustomerDTO;
import com.skip.techchallenge.model.OrderDTO;
import com.skip.techchallenge.model.OrderItemDTO;
import com.skip.techchallenge.model.ProductDTO;
import com.skip.techchallenge.util.Util;
import com.skip.techchallenge.util.OrderStatusEnum;

/************************************************************************************
 * Objective: Business object class to handle Order interactions.
 * @author feiserte
 ************************************************************************************/
public class OrderBO {

	private final Logger logger = Logger.getLogger(OrderBO.class);

	private OrderDAO orderDAO = new OrderDAO();
	private OrderItemDAO orderItemDAO = new OrderItemDAO();

	/************************************************************************************
	 * Objective: create Order
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @param customer
	 * @param productList
	 * @return Order
	 ************************************************************************************/
	public OrderDTO createOrder(CustomerDTO customer, List<ProductDTO> productList) {

		if(productList == null || productList.size() == 0 ) {
			return null;
		}

		// TODO Verify if all orders are from the same restaurant.

		OrderDTO order = new OrderDTO();
		order.setOrderDate(new SimpleDateFormat(Util.ORDER_DATA_FORMAT).format(new Date()));
		order.setCustomerId(customer.getId());
		order.setStatus(OrderStatusEnum.ORDER_CREATED.status());
		order.setDeliveryAddress(customer.getAddress());
		order.setRestaurantId(productList.get(0).getRestaurantId());
		order.setTotal(productList.stream().collect(Collectors.summingDouble(p -> p.getPrice() * p.getQuantity())));
		order.setContact(customer.getName());

		int orderId = 0;

		try {
			orderId = orderDAO.insertOrder(order);
		} catch (SQLException e) {
			String message = "Error trying to insert order into the database. Error: " + e.getMessage();
			logger.error(message);
			return null;
		}

		order.setId(orderId);

		List<OrderItemDTO> orderList = new ArrayList<OrderItemDTO>();
		orderList = productList.stream().map(p -> new OrderItemDTO(
				order.getId(), 
				p.getProductId(), 
				p.getRestaurantId(), 
				p.getPrice(), 
				p.getQuantity(), 
				p.getPrice() * p.getQuantity())
				).collect(Collectors.toList());

		for(OrderItemDTO orderItemDTO : orderList) {
			try {
				orderItemDTO.setId(orderItemDAO.insertOrderItems(orderItemDTO));
			} catch (SQLException e) {
				String message = "Error trying to insert order items into the database. Error: " + e.getMessage();
				logger.error(message);
				return null;
			}
		}

		order.setOrderItems(orderList);

		return order;
	}

	/************************************************************************************
	 * Objective: Cancel order
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @param order
	 * @return Order Status
	 ************************************************************************************/
	public String cancelOrder(Integer orderId) {
		OrderDTO order = new OrderDTO();
		order.setId(orderId);
		order.setStatus(OrderStatusEnum.ORDER_CANCELED.status());
		order.setLastUpdate(new SimpleDateFormat(Util.ORDER_DATA_FORMAT).format(new Date()));
		
		try {
			orderDAO.updateOrder(order);
		} catch (SQLException e) {
			String message = "Error trying to cancel order into the database. Error: " + e.getMessage();
			logger.error(message);
			return null;
		}

		return order.getStatus();
	}

	/************************************************************************************
	 * Objective: get Order status
	 * 
	 * @author Felipe Iserte Bonfim (felipe.iserte@gmail.com /felipe@dvdsp.com.br)
	 * @param order
	 * @return Order Status
	 ************************************************************************************/
	public String getOrderStatus(Integer orderId) {
		String status = null;
		try {
			status = orderDAO.getOrderStatus(orderId);
		} catch (SQLException e) {
			String message = "Error trying to get order status from database. Error: " + e.getMessage();
			logger.error(message);
			return null;
		}
		
		return status;
	}
}
