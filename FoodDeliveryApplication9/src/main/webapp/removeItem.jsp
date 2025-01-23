<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Menu, com.food.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Item</title>
</head>
<body>
    <h1>Remove Item</h1>

    <% 
        // Retrieve the list of items (Menu or Restaurant)
        List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
        List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurantList");
        
        // Check if we have a menu list or restaurant list
        if (menuList != null && !menuList.isEmpty()) {
            // Display the menu items
            for (Menu menuItem : menuList) {
    %>
                <div>
                    <h3><%= menuItem.getItemName() %></h3>
                    <p><%= menuItem.getDescription() %></p>
                    <p>Price: $<%= menuItem.getPrice() %></p>
                    <p><%= menuItem.getIsAvailable() ? "Available" : "Not Available" %></p>
                    <!-- Form to remove this menu item -->
                    <form action="removeMenuItem" method="POST">
                        <input type="hidden" name="menuId" value="<%= menuItem.getMenuId() %>" />
                        <button type="submit">Remove</button>
                    </form>
                </div>
    <%
            }
        } else if (restaurantList != null && !restaurantList.isEmpty()) {
            // Display the restaurant items
            for (Restaurant restaurant : restaurantList) {
    %>
                <div>
                    <h3><%= restaurant.getName() %></h3>
                    <p><%= restaurant.getCuisineType() %></p>
                    <p>Rating: <%= restaurant.getRating() %></p>
                    <!-- Form to remove this restaurant -->
                    <form action="removeRestaurant" method="POST">
                        <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>" />
                        <button type="submit">Remove</button>
                    </form>
                </div>
    <%
            }
        } else {
    %>
            <p>No items to display.</p>
    <%
        }
    %>
</body>
</html>
