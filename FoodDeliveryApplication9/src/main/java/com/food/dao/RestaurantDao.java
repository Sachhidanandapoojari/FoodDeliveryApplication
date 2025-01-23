package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Restaurant;

public interface RestaurantDao {
     void addRestaurant(Restaurant restaurant) throws ClassNotFoundException;
     Restaurant getRestaurant(int restaurantId) throws ClassNotFoundException;
     void updateRestaurant(Restaurant restaurant) throws ClassNotFoundException;
     void deleteRestaurant(int restaurentid);
     
     List<Restaurant> getAllRestaurant() throws ClassNotFoundException, SQLException;
}
