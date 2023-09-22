<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">

body{
  background: fuchsia;
}

ul {
	list-style-type: none;
	background-color: black;
	overflow: hidden;
	background-color: #333;
}
ul:hover{
 box-shadow: 2px 2px 10px white;
}

li {
	float: right;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
}

li a:hover {
	background-color: #111;
	border-radius: 20px;
	box-shadow: 3px 3px 10px white;
}
</style>
</head>
<body>
	<ul>
		<li><a style="color: white;" href="./logout">Logout</a></li>
		<li><a style="color: white;" href="./removeCar">Remove Car</a></li>
		<li><a style="color: white;" href="./updateCar">Update Car</a></li>
		<li><a style="color: white;" href="./searchCar">Search Car</a></li>
		<li><a style="color: white;" href="./addCar">Add Car</a></li>
		<li><a style="color: white;" href="./home">Home</a></li>
	</ul>
</body>
</html>