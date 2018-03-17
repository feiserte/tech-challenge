package com.skip.techchallenge.model;

public class ProductDTO {

	private Integer productId;
	private Integer restaurantId;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	
	public ProductDTO() {
		super();
	}
			
	public ProductDTO(Integer productId, Integer restaurantId, String name, String description, Double price,
			Integer quantity) {
		super();
		this.productId = productId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
