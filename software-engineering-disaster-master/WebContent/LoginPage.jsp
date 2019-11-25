<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In Page</title>
</head>
<body>
<h1>Enter your login credentials</h1>

<form action="ProcessLogin" method="get">
Enter login ID: <input type="text" name="id" /> <br /> 
Enter password: <input type="password" name="pwd" /> <br />
<input type="submit" value="Log In"/>
</form>

</body>
</html>