package com.food.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.food.daoimpl.RestaurantDaoImpl;
import com.food.model.Restaurant;

/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RestaurantDaoImpl obj=new RestaurantDaoImpl();
		List<Restaurant> restaurant = obj.getAllRestaurant();
//		for(Restaurant restaurants:restaurant) {
//			System.out.println(restaurants.getName());
//			System.out.println(restaurants.getCuisineType());
//		}  
		request.setAttribute("restaurantList", restaurant);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
	}

}
