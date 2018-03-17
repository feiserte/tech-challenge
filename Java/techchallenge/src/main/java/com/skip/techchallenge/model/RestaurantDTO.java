package com.skip.techchallenge.model;

public class RestaurantDTO {

	private Integer restaurantId;
	private String name;
	private String description;
	private String address;
	private double longitude;
	private double lagitude;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLagitude() {
		return lagitude;
	}
	public void setLagitude(double lagitude) {
		this.lagitude = lagitude;
	}
	
}
