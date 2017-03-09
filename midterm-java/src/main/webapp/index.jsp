<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/template.css" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<title>Login</title>
</head>
<body>
	<center>
		<form class="flogin" action="LoginServlet">
			<h2 class="tsignin"><i class="fa fa-lock" aria-hidden="true"></i>SIGN IN</h2>
			<table>
				<tr>
					<td>User Name: </td>
					<td><input type="text" name="un"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input type="password" name="pw"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<hr/>
					</td>
				</tr>	
				<tr>
					<td colspan="2">
						<center>
							<input class="bsignin" type="submit" value="Sign in">
						</center>
					</td>
				</tr>
			</table>
		</form>
	</center>	
</body>
</html>