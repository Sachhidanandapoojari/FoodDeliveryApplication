package com.food.model;

import java.math.BigDecimal;

public class Restaurant {
    private int restaurentId;
    private String name;
    private String cuisineType;
    private int deliveryTime;
    private String address;
    private int adminUserId;
    private double rating;
    private boolean isActive;
    
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getCuisineType() {
		// TODO Auto-generated method stub
		return cuisineType;
	}

	public int getDeliveryTime() {
		// TODO Auto-generated method stub
		return (Integer) deliveryTime;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	public int getAdminUserID() {
		// TODO Auto-generated method stub
		return (Integer) adminUserId;
	}

	public double getRating() {
		// TODO Auto-generated method stub
		return (Double) rating;
	}

	public boolean getIsActive() {
		// TODO Auto-generated method stub
		return (Boolean) isActive;
	}

	public int getRestaurantId() {
		// TODO Auto-generated method stub
		return restaurentId;
	}

	public void setRestaurantId(int int1) {
		// TODO Auto-generated method stub
		restaurentId=int1;
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		name=string;
	}

	public void setCuisineType(String string) {
		// TODO Auto-generated method stub
		cuisineType=string;
	}

	public void setDeliveryTime(int int1) {
		// TODO Auto-generated method stub
		deliveryTime=int1;
	}

	public void setAddress(String string) {
		// TODO Auto-generated method stub
		address=string;
	}

	public void setAdminUserID(int int1) {
		// TODO Auto-generated method stub
		adminUserId=int1;
	}

	public void setRating(double double1) {
		// TODO Auto-generated method stub
		rating=double1;
	}

	public void setIsActive(boolean boolean1) {
		// TODO Auto-generated method stub
		isActive=boolean1;
	}

	public void setId(int int1) {
		// TODO Auto-generated method stub
		
	}

	
}
