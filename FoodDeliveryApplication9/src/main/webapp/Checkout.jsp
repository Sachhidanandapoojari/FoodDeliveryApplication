<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h2>Your Shopping Cart</h2>

    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Item</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%-- Example of a cart item --%>
            <tr>
                <td>Sample Item</td>
                <td>1</td>
                <td>$10.00</td>
                <td>$10.00</td>
                <td><a href="removeItem.jsp?id=1">Remove</a></td>
            </tr>
            <%-- Additional items can be dynamically added here using JSP scripting --%>
        </tbody>
    </table>

    <h3>Total: $<span id="cart-total">10.00</span></h3>
   

</body>
</html>