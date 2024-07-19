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
    <a href="Order.jsp">-create order</a>
    <a href="#">-Supplier sample</a>
    <a href="#">-required items</a>
    </div>
  <a href="#">Manage accounts</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>


<form action="insert" method="post">
<h1>Manage inventory managers</h1>
		Name <input class="box" type="text" name="name" required><br>
		Email <input class="box" type="email" name="email pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required><br>
		Phone Number <input class="box" type="text" name="phone" pattern="[0-9]{10}" required><br>
		User Name <input class="box" type="text" name="uid"><br>
		Password <input class="box" type="password" name="psw"><br>
		
		<center><input class="submitBtn" type="submit" name="submit" value="Add"></center>
</form>

<c:if test="${not empty success}">
    <c:if test="${success == true}">
        <h2>User added successfully!</h2>
    </c:if>
    <c:if test="${success == false}">
        <h2>Failed to add user.</h2>
    </c:if>
</c:if>




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