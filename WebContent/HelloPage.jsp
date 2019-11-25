<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<h1>Test Car Reg page - WIP, To be removed.</h1>

<%
	if (session.getAttribute("Login") == null){
		response.sendRedirect("LoginPage.jsp");
	}
%>

<p> Hello ${Id}</p>
<p> Login Successful!!</p>
<p> Role: ${Role}</p>

<form action="ProcessLogout">
	<input type="submit" value="Log out" />
</form>

</body>
</html>