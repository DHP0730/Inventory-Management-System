<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/adminHome.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  
  <a href="#">Home</a>
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
  <a href="ManageAccounts.jsp">Manage accounts</a>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; </span>

<div class="main">
<form>
  <h2>Welcome<c:forEach var="cus" items="${adDetails}"> ${cus.name}
  </c:forEach></h2>
  <p>In the realm of clothing retail, precision in stock management is vital for success.</p>
  <p>As trends and seasons shift, the need for an efficient Stock Management System becomes imperative.</p>
  <p>Our solution is tailored to meet the unique requirements of clothing stores, ensuring optimal inventory control.</p>
  <p>This system empowers you to stay agile, cut costs, and maximize profits in the ever-evolving world of fashion.</p>
</form>
</div>



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