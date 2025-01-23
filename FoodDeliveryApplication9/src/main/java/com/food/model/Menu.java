package com.food.model;

public class Menu {
      private int menuId;
      private int restaurantId;
      private String itemName;
      private String description;
      private double price;
      private boolean isAvailable;
      
      
      
    public int getMenuId() {
    	return menuId;
    }
    
    public int getRestaurantId() {
    	return restaurantId;
    }
    
    public String getItemName() {
    	return itemName;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public double getPrice() {
    	return price;
    }
    
    public boolean getIsAvailable() {
    	return isAvailable;
    }
	public void setMenuId(int int1) {
		 menuId=int1;
		
	}
	public void setRestaurantId(int int1) {
		restaurantId=int1;
		
	}
	public void setItemName(String string) {
		itemName=string;
		
	}
	public void setDescription(String string) {
		description=string;
		
	}
	public void setPrice(double double1) {
		price=double1;
		
	}

	public void setAvailable(boolean boolean1) {
		isAvailable=boolean1;
		
	}
      
}
