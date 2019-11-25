
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<h1>Search Menu</h1>
<form method="post" action="SearchController">
<h2>Search Information</h2>
Enter Make (ex. Toyota, Honda): <br>
<input type ="text" name="makename">
<br><br><br>
Enter Model (ex. Corolla, Camry): <br>
<input type ="text" name="modelname">
<br><br><br>
Enter Number of Passengers: <br>
<input type ="text" name="passname">
<br><br><br>
Enter Year (ex.2012): <br>
<input type ="text" name="yearname">
<br><br><br>
Search Found: <br>
<textarea name="sreturn" readonly rows="4" cols="50" style="display:none;">
</textarea> <br><br>
${vehicle}
<input type="submit" name="button" value="Search" />
</form>
</body>
</html>