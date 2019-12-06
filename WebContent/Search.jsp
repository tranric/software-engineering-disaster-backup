<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
			<div class="collapse navbar-collapse w-100 order-1 order-md-0 dual-collapse2" id="navbar-dropdown">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a href="NewRecord.html" class="nav-link">New Record</a>
					</li>
					<li class="nav-item active">
						<a href="#" class="nav-link">Search</a>
					</li>
				</ul>
			</div>
			
			<div class="mx-auto order-0">
				<a href="HomePageInitController.do" class="navbar-brand mx-auto">Daniel &amp; Son's Car Registry</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			
			<div class="collapse navbar-collapse w-100 order-3 dual-collapse2">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a href="ProcessLogout" class="btn btn-outline-primary nav-link">Logout</a>
					</li>
				</ul>
			</div>
		</nav>
	
		<div class="container">
			<h1>Search</h1>
			<p class="text-muted">Enter something in one or several fields to find necessary records.</p>
			
			<form action="SearchController" method="POST">
				<div class="row">
					<div class="col-3 font-weight-bold">VIN</div>
					<div class="col">
						<input class="form-control" type="text" name="vin" placeholder="e.g. JT4RN13P7K0001611">
					</div>
				</div>
				<div class="row">
					<div class="col-3 font-weight-bold">Full Name</div>
					<div class="col">
						<div class="input-group">
							<input type="text" class="form-control" name="first-name" placeholder="First name">
							<input type="text" class="form-control" name="middle-initial" placeholder="Middle initial">
							<input type="text" class="form-control" name="last-name"  placeholder="Last name">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-3 font-weight-bold">Registration date</div>
					<div class="col">
						<input class="form-control" type="date" name="reg-date">
					</div>
				</div>
				<div class="row justify-content-end">
					<button type="submit" class="btn btn-primary btn-page-bottom" name="button">Search</button>	
				</div>
			</form>
		</div>
		
		<div class="container">
			<c:choose>
				<c:when test="${searchResult == null}">
					<%-- This condition is used when the page is opened for the first time --%>
				</c:when>
				<c:when test="${empty searchResult}">
					<div class="row w-100 nothing-to-show">
						<div class="mx-auto">
							<h2>No records found</h2>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-striped table-sticky" style="margin-top: 30px;">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Name</th>
								<th scope="col">Vehicle</th>
								<th scope="col">Registration Date</th>
								<th scope="col">Details</th>
							</tr>						
						</thead>
						<tbody class="table-hover">
							<c:forEach items="${searchResult}" var="record" varStatus="loop">
								<tr>
									<td scope="col" class="align-middle">
										${record.owner.firstName} 
										<c:if test="${!empty record.owner.middleInitial}">${record.owner.middleInitial}.</c:if>
										${record.owner.lastName}
									</td>
									<td scope="col" class="align-middle">${record.vehicle.vehicleDetails.color} ${record.vehicle.make} ${record.vehicle.model} (${record.vehicle.year})</td>
									<td scope="col" class="align-middle">${record.registerDate}</td>
									<td scope="col" class="align-middle">
										<form action="ViewDetails.do" method="POST">
											<input type="hidden" name="record-index" value="${loop.index}">
											<button type="submit" class="btn btn-primary">View</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>