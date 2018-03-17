package com.skip.techchallenge.model;

public class OrderItemDTO {

	private Integer id;
	private Integer orderId;
	private Integer productId;
	private Integer restaurantId;
	private ProductDTO product;
	private Double price;
	private int quantity;
	private double total;
	
	public OrderItemDTO() {
		super();
	}

	public OrderItemDTO(Integer orderId, Integer productId, Integer restaurantId, Double price, Integer quantity, Double total) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.restaurantId = restaurantId;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public Double getPrice() {
		return price;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
