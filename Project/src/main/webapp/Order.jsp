<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ManageAccounts.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
  <a href="adminHome.jsp">Home</a>
  <a href="#">Manage discounts</a>
  <a href="#">Modify prices</a>
  <a href="#">Suppliers</a>
  <button class="dropdown-btn">Reports 
    <i class="fa fa-caret-down"></i>
  </button>
    <div class="dropdown-container">
    <a href="#">-create order</a>
    <a href="#">-Supplier sample</a>
    <a href="#">-required items</a>
    </div>
  <a href="ManageAccounts.jsp">Manage accounts</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>


<form action="see" method="post">
<center>
	<input class="submitBtn" type="submit" name="submit" value="view saved reports">
</center>
</form>



<form action="view">
<table border = 1 id="tabledec">
	
	<tr>
		<th>Order no.</th>
		<th>Category</th>
		<th>Item name</th>
		<th>Size</th>
		<th>quantity</th>
		<th>Supplier ID</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach var="it" items="${itemDetails}">
	
	<c:set var="orderno" value="${it.orderno}"/>
	<c:set var="category" value="${it.category}"/>
	<c:set var="name" value="${it.name}"/>
	<c:set var="size" value="${it.size}"/>
	<c:set var="quantity" value="${it.quantity}"/>
	<c:set var="supplierid" value="${it.supplierid}"/>
	
	<tr>
		<td>${it.orderno}</td>
		<td>${it.category}</td>
		<td>${it.name}</td>
		<td>${it.size}</td>
		<td>${it.quantity}</td>
		<td>${it.supplierid}</td>
		<td>
			<c:url value="updateorder.jsp" var="itmupdate">
				<c:param name="orderno" value="${orderno}"/>
				<c:param name="category" value="${category}"/>
				<c:param name="name" value="${name}"/>
				<c:param name="size" value="${size}"/>
				<c:param name="quantity" value="${quantity}"/>
				<c:param name="supplierid" value="${supplierid}"/>
			</c:url>
			
				<a href="${itmupdate}">
					<input class= "btn" type="button" name="update" value="Update">
				</a>
		</td>
		<td>
		
			<c:url value="deleteorder.jsp" var="itmdelete">
				<c:param name="orderno" value="${orderno}"/>
				<c:param name="category" value="${category}"/>
				<c:param name="name" value="${name}"/>
				<c:param name="size" value="${size}"/>
				<c:param name="quantity" value="${quantity}"/>
				<c:param name="supplierid" value="${supplierid}"/>
			</c:url>
			<a href="${itmdelete}">
				<input class= "btn" type="button" name="delete" value="Delete">
			</a>
		</td>
	</tr>
	</c:forEach>
	</table>
	
</form>	

<form action="insertorder" method="post">
<h1>Create Order</h1>
	    Category<input class="box" type="text" name="category" required><br>
		Name <input class="box" type="text" name="name" required><br>
		Size <input class="box" type="text" name="size" required><br>
		Quantity <input class="box" type="text" name="qty" required><br>
		Supplier ID <input class="box" type="text" name="supid" required><br>
		
		<center><input class="submitBtn" type="submit" name="submit" value="Add data"></center>
</form>	


<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>

<script>
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
      dropdownContent.style.display = "none";
    } else {
      dropdownContent.style.display = "block";
    }
  });
}
</script>	

</body>
</html>