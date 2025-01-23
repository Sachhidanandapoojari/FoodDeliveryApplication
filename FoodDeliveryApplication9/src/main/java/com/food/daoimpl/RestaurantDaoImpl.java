package com.food.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.food.dao.RestaurantDao;
import com.food.model.Restaurant;
import com.food.util.DBConnectionUtil;

public class RestaurantDaoImpl implements RestaurantDao {

	private Restaurant restaurant;


	@Override
	public void addRestaurant(Restaurant restaurant) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String sql="Insert into restaurant(Name, CuisineType, DeliveryTime, Address, Rating, IsActive) values(?, ?, ?, ?, ?, ?)";
		try (Connection conn=DBConnectionUtil.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			    pstm.setString(1, restaurant.getName());
			    pstm.setString(2, restaurant.getCuisineType());
			    pstm.setInt(3, restaurant.getDeliveryTime());
			    pstm.setString(4, restaurant.getAddress());
			    pstm.setDouble(5, restaurant.getRating());
			    pstm.setBoolean(6, restaurant.getIsActive());
			    pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) throws ClassNotFoundException {
		String sql="select * from restaurant where RestaurantID=?";
		Restaurant restaurant = null;
		
		try(Connection conn=DBConnectionUtil.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)) {
			pstm.setInt(1,restaurantId);
			try (ResultSet res=pstm.executeQuery()){
				if(res.next()) {
					restaurant=extractRestaurantfromResultSet(res);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurant;
	}

	private Restaurant extractRestaurantfromResultSet(ResultSet res)    {
		Restaurant restaurant = new Restaurant();
        try {
            restaurant.setRestaurantId(res.getInt("RestaurantID"));
            restaurant.setName(res.getString("Name"));
            restaurant.setCuisineType(res.getString("CuisineType"));
            restaurant.setDeliveryTime(res.getInt("DeliveryTime"));
            restaurant.setAddress(res.getString("Address"));
            restaurant.setAdminUserID(res.getInt("AdminUserID"));
            restaurant.setRating(res.getDouble("Rating"));
            restaurant.setIsActive(res.getBoolean("IsActive"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    
	}

	
	@Override
	public void deleteRestaurant(int restaurentid) {
		// TODO Auto-generated method stub
		String sql="delete from restaurant where RestaurantID=?";
		
		try (Connection conn=DBConnectionUtil.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setInt(1,restaurentid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
	    List<Restaurant> restaurants = new ArrayList<>();
	    String sql = "SELECT * FROM restaurant";
	    try (Connection conn = DBConnectionUtil.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Restaurant restaurant = new Restaurant();
	            restaurant.setRestaurantId(rs.getInt("RestaurantID"));
	            restaurant.setName(rs.getString("Name"));
	            restaurant.setCuisineType(rs.getString("CuisineType"));
	            restaurant.setDeliveryTime(rs.getInt("DeliveryTime"));
	            restaurant.setAddress(rs.getString("Address"));
	            restaurant.setAdminUserID(rs.getInt("AdminUserID"));
	            restaurant.setRating(rs.getDouble("Rating"));
	            restaurant.setIsActive(rs.getBoolean("IsActive"));
	            restaurants.add(restaurant);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return restaurants;
	}


	
	
	@Override
	public void updateRestaurant(Restaurant restaurant) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String sql="update restaurant set Name= ? , CuisineType=?, DeliveryTime=?, Address=?, AdminUserID=?, Rating=?, IsActive=? WHERE RestaurantID=? ";
		try(Connection conn=DBConnectionUtil.getConnection();
				PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setString(1, restaurant.getName());
			pstm.setString(2, restaurant.getCuisineType());
			pstm.setInt(3, restaurant.getDeliveryTime());
			pstm.setString(4, restaurant.getAddress());
			pstm.setInt(5, restaurant.getAdminUserID());
			pstm.setDouble(6, restaurant.getRating());
			pstm.setBoolean(7, restaurant.getIsActive());
			pstm.setInt(8, restaurant.getRestaurantId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
