<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <jsp:include page="NavBar.jsp"></jsp:include>
	 <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
  background: teal;
}
#btn{
background: orange;
}
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

tr>th {
	color: red;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}
fieldset:hover{
 box-shadow: 2px 2px 15px white; 
}

legend {
	color: white;
	text-align:center;
	background-color: #333;
}

</style>
</head>
<body>
	<div align="center">
		<fieldset >
			<legend>Add Car</legend>
			<form action="./addCar" method="post">
				<table>
					<tr>
						<td>Car Name</td>
						<td> <input type="text" name="name"> </td>
					</tr>
					<tr>
						<td>Car FuelType</td>
						<td><input type="text" name="fuelType"></td>
					</tr>
					<tr>
						<td>Car Model</td>
						<td><input type="text" name="model"></td>
					</tr>
					<tr>
						<td>Car Price</td>
						<td><input type="text" name="price"></td>
					</tr>
				</table>
				<input type="submit" id="btn" value="ADD CAR">
			</form>

		</fieldset>
		<% if(msg != null){ %>
		<h3><%=msg %></h3>
		<%} %>
	</div>
</body>
</html>
