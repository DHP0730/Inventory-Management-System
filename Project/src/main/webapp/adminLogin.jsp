<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>

<body>

<form action="adminLogin" method="post">

<h1>LOGIN</h1>

<h4>Username:</h4>
<input class="box" type="text" name="username" placeholder="Enter Username" required><br><br>

<h4>Password:</h4>
<input class="box" type="password" name="password" placeholder="Enter Password" required><br><br>

<center>
<input class="submitBtn" type="submit" name="submit" value="Login">
</center>

</form>

</body>
</html>