<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Menu</h1>
	<div class="menu-container">
		<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
		%>
		<p style="color: red;"><%=error%></p>
		<%
		} else {
		List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
		if (menuList != null && !menuList.isEmpty()) {
			for (Menu menuItem : menuList) {
		%>
		<div class="menu-item">
			<h3><%=menuItem.getItemName()%></h3>
			<p><%=menuItem.getDescription()%></p>
			<p>
				Price: $<%=menuItem.getPrice()%></p>
			<p><%=menuItem.getIsAvailable() ? "Available" : "Not Available"%></p>

			<form action="cart" method="get">
				<input type="hidden" name="itemId" value="<%=menuItem.getMenuId()%>">
				Quantity: <input type="number" name="quantity" value="1" min="1"
				class="quantity-input">  <input type="submit" value="add to cart" class="add-to-cart-btn">
			     <input type="hidden" name="action" value="add">
			</form>
		</div>
		<%
		}
		} else {
		%>
		<p>No menu items available for this restaurant.</p>
		<%
		}
		}
		%>
	</div>
</body>
</html>
