<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Page</title>
		
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
					<li class="nav-item">
						<a href="Search.jsp" class="nav-link">Search</a>
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
			<c:choose>
				<c:when test="${empty sessionScope.records}">
					<div class="row w-100 nothing-to-show">
						<div class="mx-auto">
							<span class="display-1">:(</span>
							<br />
							<h2>There is nothing here right now.</h2>
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
							<c:forEach items="${sessionScope.records}" var="record" varStatus="loop">
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