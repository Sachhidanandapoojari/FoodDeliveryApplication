package com.food.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDao;
import com.food.daoimpl.MenuDaoImpl;

/**
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private MenuDao menuDao;
	

	
	public void init(ServletConfig config)throws ServletException{
		menuDao=new MenuDaoImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Retrieve the RestaurantID from the request
        String restaurantIdStr = request.getParameter("RestaurantID");

        // If RestaurantID is not provided, we do not fetch the menu
        if (restaurantIdStr == null || restaurantIdStr.isEmpty()) {
            // Simply set the menuList as empty and proceed
            request.setAttribute("menuList", new ArrayList<Menu>());
        } else {
            try {
                // Parse the RestaurantID to integer
                int restaurantId = Integer.parseInt(restaurantIdStr);

                // Instantiate the MenuDaoImpl
                MenuDaoImpl menuDao = new MenuDaoImpl();

                // Fetch the menu items for the given RestaurantID
                List<com.food.model.Menu> menuList = menuDao.getAllMenusByRestaurant(restaurantId);

                // Set the menu list as a request attribute
                request.setAttribute("menuList", menuList);

            } catch (NumberFormatException e) {
                // If the RestaurantID is invalid, we just set an empty menu list
                request.setAttribute("menuList", new ArrayList<Menu>());
            } catch (Exception e) {
                // Handle any other exceptions
                e.printStackTrace();
                request.setAttribute("menuList", new ArrayList<Menu>());
            }
        }

        // Forward to the Menu.jsp page to display the menu list
        RequestDispatcher dispatcher = request.getRequestDispatcher("Menu.jsp");
        dispatcher.include(request, response);
	}

	


}
