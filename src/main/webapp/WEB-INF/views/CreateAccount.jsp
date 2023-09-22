<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
  background: fuchsia;
}
fieldset:hover{
 box-shadow: 2px 2px 15px white; 
}
</style>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Create new Account</legend>
			<form action="./createAccount"  method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td>  <input type="text" name="password"> </td>
					</tr>
				</table>
				<input type="submit" value="CREATE ADMIN">
			</form>
		</fieldset>
		
	</div>
</body>
</html>