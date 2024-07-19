<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ManageAccounts.css">
</head>
<body>

	<%
		String orderno = request.getParameter("orderno");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String size = request.getParameter("size");
		String quantity = request.getParameter("quantity");
		String supplierid = request.getParameter("supplierid");
	%>
	
	<form action="delete" method="post">
	<table>
		<tr>
			<td>order number</td>
			<td><input class="box1" type="text" name="orderno" value="<%= orderno %>" readonly></td>
		</tr>
		<tr>
			<td>category</td>
			<td><input class="box1" type="text" name="cat" value="<%= category %>" readonly></td>
		</tr>
		<tr>
			<td>name</td>
			<td><input class="box1" type="text" name="iname" value="<%= name %>" readonly></td>
		</tr>
		<tr>
		<td>size</td>
		<td><input class="box1" type="text" name="size" value="<%= size %>" readonly></td>
	</tr>
	<tr>
		<td>quantity</td>
		<td><input class="box1" type="text" name="qty" value="<%= quantity %>" readonly></td>
	</tr>
	<tr>
		<td>supplierID</td>
		<td><input class="box1" type="text" name="supid" value="<%= supplierid %>" readonly></td>
	</tr>
			
	</table>
	<br>
	<center>
	<input class="submitBtn" type="submit" name="submit" value="Delete Data">
	<a href="Order.jsp" class="back">cancel</a>
	</center>
	</form>
</body>
</html>