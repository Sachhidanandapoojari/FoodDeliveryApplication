<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>
</head>
<body>



	<%
	List<Restaurant> restaurant = (List<Restaurant>) request.getAttribute("restaurantList");

	for (Restaurant restaurants : restaurant) {
	%>
	<div>
		<h3><%=restaurants.getName()%></h3>
		<p>
			Rating:
			<%=restaurants.getRating()%></p>
		<h3>
			ETA:
			<%=restaurants.getDeliveryTime()%>
			mins
		</h3>
		<h3><%=restaurants.getCuisineType()%>
			cuisine
		</h3>
		
		
		<form action="Menu" method="GET">
			<input type="number" name="RestaurantID" value="4" min="3">
			<button type="submit">View Menu</button>
		</form>
         <br>
        <form action="Checkout.jsp" method="post">
        <input type="submit" value="Proceed to Checkout">
        </form>   
		<h3>----------------------------------------------------------------------------------------------------------------------------------------</h3>
	</div>
	
	
	<%
	}
	%>

    <p>Don't have an account? <a href="Login.jsp">Register here</a>.</p>


</body>
</html>