<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Details</title>
		
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
			<div class="row">
				<div class="col">
					<form action="PrepRecordUpdateController.do" method="POST">
						<input type="hidden" name="recordAsString" value="${recordAsString}"> <!-- Not the best data passing between two web pages, but I don't want to deal with cookies and GDPR right now -->
						<input type="submit" class="btn btn-primary btn-page-top" value="Edit">
					</form>
				</div>
			</div>
			<div class="row justify-content-between">
				<div class="card card-block col-xs-12 col-lg-6">
					<h1 class="display-4">
						${record.owner.firstName} 
						<c:if test="${!empty record.owner.middleInitial}">${record.owner.middleInitial}.</c:if>
						${record.owner.lastName}
					</h1>
					<span>Registered on <b>${record.registerDate}</b></span>
					
					<br /><br />
					
					<h2>Contact Information</h2>
					<address>
						Address: 
						<b>
							${record.owner.address.streetNumber} 
							${record.owner.address.streetName}
							<c:if test="${!empty record.owner.address.unit}"> (Apt/Unit ${record.owner.address.unit})</c:if>, 
							${record.owner.address.city}, 
							${record.owner.address.province}, 
							${record.owner.address.postalCode} 
						</b>
						<br />
						E-mail: <b>${record.owner.email}</b>
						<br />
						Phone: <b>${record.owner.phone}</b>
					</address>
				</div>
				<div class="card card-block col-xs-12 col-lg-6">
					<h2>License Plate</h2>
					<h1 class="mx-auto display-3">${record.issuedPlate.plateNumber}</h1>
					
					<div>
						Issued on <b>${record.issuedPlate.issueDate}</b> <br />
						Expires on <b>${record.issuedPlate.expiryDate}</b>
					</div>
				</div>
			</div>
			<div class="row card card-block">
				<div class="col">
					<h2>Vehicle Information</h2>
					<span class="h5">${record.vehicle.make} ${record.vehicle.model} (${record.vehicle.year})</span> <br /><br />
					<span><b>Color:</b> ${record.vehicle.vehicleDetails.color}</span>  <br />
					<span><b>Weight:</b> ${record.vehicle.weight} kg</span>  <br />
					<span><b>Number of passengers:</b> ${record.vehicle.passengers}</span>  <br />
					<span><b>Color:</b> ${record.vehicle.vehicleDetails.color}</span>  <br />
					<span><b>Cost:</b> ${record.vehicle.cost} CAD</span>  <br />
					<span><b>Body style:</b> ${record.vehicle.bodyStyle}</span>  <br />
					<span>
						<b>
							<c:choose>
								<c:when test="${record.vehicle.diesel}">Uses </c:when>
								<c:otherwise>Doesn't use </c:otherwise>
							</c:choose>
							diesel fuel
						</b>
					</span>
				</div>
				<c:if test="${!empty record.insuranceName && !empty record.insuranceExpiry}">
					<div class="col">
						<h2>Insurance information</h2>
						<span class="font-weight-bold">${record.insuranceName} expires on ${record.insuranceExpiry}</span>
					</div>
				</c:if>
			</div>
		</div>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>