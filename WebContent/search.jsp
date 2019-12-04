<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<div class="container">
			<h1>Search</h1>
			<p class="text-muted">Enter something in one or several fields to find necessary records.</p>
			
			<form action="SearchController" method="POST">
				<div class="row">
					<div class="col-3 font-weight-bold">Make</div>
					<div class="col">
						<input class="form-control" type="text" name="makename">
					</div>
				</div>
				<div class="row">
					<div class="col-3 font-weight-bold">Model</div>
					<div class="col">
						<input class="form-control" type="text" name="modelname">
					</div>
				</div>
				<div class="row">
					<div class="col-3 font-weight-bold">Year</div>
					<div class="col">
						<input class="form-control" type="text" name="yearname">
					</div>
				</div>
				<div class="row">
					<div class="col-3 font-weight-bold">Number of passengers</div>
					<div class="col">
						<input class="form-control" type="text" name="passname">
					</div>
				</div>
				
				Search Found: <br>
				<textarea name="sreturn" readonly rows="4" cols="50" style="display:none;">
				</textarea> <br><br>
				${vehicle}
				<button type="submit" class="btn btn-primary btn-block" name="button">Search</button>	
			</form>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>