<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
	background-color: #333;
}

</style>
</head>
<body>
	<div Align="center">
	
	<%if(msg != null){%>
	<h3><%= msg %></h3>
	<%} %>
		<fieldset>
			<legend>Log in</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td> <input type="text" name="username"> </td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="LOGIN">
			</form>
			<a href="http://localhost:8081/cardekhoapplicationusingmvc/createAccount">Dont have an account?create New Account</a>
		</fieldset>
		
	</div>
</body>
</html>