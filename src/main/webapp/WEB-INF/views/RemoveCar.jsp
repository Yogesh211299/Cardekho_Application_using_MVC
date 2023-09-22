<%@page import="com.jspiders.cardekhoapplicationusingmvc.pojo.CarPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");
List<CarPojo> cars = (List<CarPojo>) request.getAttribute("cars");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#btn{
background: orange;
}
body{
  background: activeborder;
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
tr>#td{
color: white;
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
	background-color: #333;
}

#tab1 {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#tab1 td {
	text-align: center;
	border: 1px solid black;
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Remove car</legend>
			<form action="./removeCar" method="post">
				<table>
					<tr>
						<td id="td">ENTER ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="REMOVE">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>

		<%
		if (cars != null) {
		%>
		<table id="tab1">
			<tr>
				<th>CarID</th>
				<th>CarName</th>
				<th>CarModel</th>
				<th>CarFuelType</th>
				<th>CarPrice</th>
			</tr>
			<%for(CarPojo car:cars){ %>
			<tr>
			<td><%=car.getId() %></td>
			<td><%=car.getName() %></td>
			<td><%=car.getModel() %></td>
			<td><%=car.getFuelType() %></td>
			<td><%=car.getPrice()%></td>
			</tr>
			
			<%} %>
		</table>


		<%
		}
		%>
	</div>

</body>
</html>