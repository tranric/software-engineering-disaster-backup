<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Record</title>
		
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
			<h1>Update Record</h1>
			
			<form action="UpdateRegistry.do" method="POST">
				<input type="hidden" name="currentRecordAsString" value="${currentRecordAsString}">
				<div class="form-group registry-info">
					<div class="row">
						<div class="col"><h5>Registration Information</h5></div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Issue date</div>
						<div class="col">
							<input type="date" class="form-control" name="reg-issue-date" value="${record.registerDate}" required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Registration fee</div>
						<div class="col">
							<div class="input-group">
								<input type="text" class="form-control" name="reg-fee" value="${record.tax}" placeholder="e.g. 50.00" pattern="^([0-9]+([.][0-9]*)?|[.][0-9]+)$" required>
								<div class="input-group-append">
									<span class="input-group-text">CAD</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Branch</div>
						<div class="col">
							<input type="text" class="form-control" maxlength="20" name="reg-branch" value="${record.branch}">
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Lien</div>
						<div class="col">
							<input type="text" class="form-control" maxlength="255" name="reg-lien" value="${record.lien}">
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Insurance name</div>
						<div class="col">
							<input type="text" class="form-control" maxlength="255" name="reg-insurance-name" value="${record.insuranceName}">
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Insurance valid until</div>
						<div class="col">
							<input type="date" class="form-control" name="reg-insurance-valid" value="${record.insuranceExpiry}" required>
						</div>
					</div>
				</div>
				
				<!-- In case if this won't be needed here, you can cut and paste this in the "New user" page. -->
				<div class="form-group owner-info">
					<div class="row">
						<div class="col"><h5>Vehicle Owner Information</h5></div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Driver Licence Number</div>
						<div class="col">
							<input type="text" class="form-control" maxlength="10" value="${record.owner.driverLicence}" name="driver-licence" pattern="^[0-9]+$" required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Full name</div>
						<div class="col">
							<div class="input-group">
								<input type="text" class="form-control" name="first-name"     value="${record.owner.firstName}" maxlength="20" placeholder="First" required>
								<input type="text" class="form-control" name="middle-initial" value="${record.owner.middleInitial}" maxlength="1" placeholder="Middle Initial (optional)" maxlength="1">
								<input type="text" class="form-control" name="last-name"      value="${record.owner.lastName}" maxlength="10" placeholder="Last" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Gender</div>
						<div class="col">
							<div class="custom-control custom-radio custom-control-inline padded-input">
								<input type="radio" id="gender-radio1" class="custom-control-input" name="gender-radio" value="M"  ${record.owner.gender == 'M' ? 'checked' : ''}>
								<label for="gender-radio1" class="custom-control-label">M</label>
							</div>
							<div class="custom-control custom-radio custom-control-inline padded-input">
								<input type="radio" id="gender-radio2" class="custom-control-input" name="gender-radio" value="F"  ${record.owner.gender == 'F' ? 'checked' : ''}>
								<label for="gender-radio2" class="custom-control-label">F</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Email</div>
						<div class="col">
							<input type="email" class="form-control" name="owner-email" value="${record.owner.email}" required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Phone</div>
						<div class="col">
							<input type="tel" class="form-control" name="owner-phone" value="${record.owner.phone}" required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Date of birth</div>
						<div class="col">
							<input type="date" class="form-control" name="owner-dob" value="${record.owner.dateOfBirth}" required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Address</div>
						<div class="col">
							<div class="input-group">
								<input type="text" class="form-control" name="str-no"   value="${record.owner.address.streetNumber}" placeholder="Street No." pattern="^[0-9]+$" required>
								<input type="text" class="form-control" name="str-name" value="${record.owner.address.streetName}" maxlength="50" placeholder="Street Name" required>
								<input type="text" class="form-control" name="apt-no"   value="${record.owner.address.unit}" maxlength="8" placeholder="Apartment No.">
							</div>
							<input type="text" class="form-control" name="post-code" value="${record.owner.address.postalCode}" maxlength="6" placeholder="Postal Code (no spaces)" pattern="^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$" required>
							<input type="text" class="form-control" name="city"      value="${record.owner.address.city}" maxlength="10" placeholder="City" required>
							<select class="form-control" name="province" required>
								<option value="AB" ${record.owner.address.province == 'AB' ? 'selected' : ''}>Alberta</option>
								<option value="BC" ${record.owner.address.province == 'BC' ? 'selected' : ''}>British Columbia</option>
								<option value="MB" ${record.owner.address.province == 'MB' ? 'selected' : ''}>Manitoba</option>
								<option value="NB" ${record.owner.address.province == 'NB' ? 'selected' : ''}>New Brunswick</option>
								<option value="NL" ${record.owner.address.province == 'NL' ? 'selected' : ''}>Newfoundland</option>
								<option value="NT" ${record.owner.address.province == 'NT' ? 'selected' : ''}>Northwest Territories</option>
								<option value="NS" ${record.owner.address.province == 'NS' ? 'selected' : ''}>Nova Scotia</option>
								<option value="NU" ${record.owner.address.province == 'NU' ? 'selected' : ''}>Nunavut</option>
								<option value="ON" ${record.owner.address.province == 'ON' ? 'selected' : ''}>Ontario</option>
								<option value="PE" ${record.owner.address.province == 'PE' ? 'selected' : ''}>Prince Edward Island</option>
								<option value="QC" ${record.owner.address.province == 'QC' ? 'selected' : ''}>Quebec</option>
								<option value="SK" ${record.owner.address.province == 'SK' ? 'selected' : ''}>Saskachewan</option>
								<option value="YT" ${record.owner.address.province == 'YT' ? 'selected' : ''}>Yukon</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="form-group vehicle-info">
					<div class="row">
						<div class="col"><h5>Vehicle</h5></div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">VIN</div>
						<div class="col">
							<input type="text" class="form-control" name="vin" value="${record.vehicle.vehicleDetails.vin}" maxlength="28" placeholder="e.g. JT4RN13P7K0001611">
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Properties</div>
						<div class="col">
							<div class="input-group">
								<input type="text" class="form-control" name="make"   value="${record.vehicle.make}" maxlength="10" placeholder="Make" required>
								<input type="text" class="form-control" name="model"  value="${record.vehicle.model}" maxlength="10" placeholder="Model" required>
								<input type="number" class="form-control" name="made" value="${record.vehicle.year}" maxlength="4" placeholder="Year" required>
							</div>
							
							<input type="text" class="form-control" name="model-type" value="${record.vehicle.modelType}" maxlength="20" placeholder="Model type" required>
							<input type="text" class="form-control" name="body-style" value="${record.vehicle.bodyStyle}" maxlength="20" placeholder="Body style" required>
							
							<div class="input-group">								
								<input type="text" class="form-control" name="weight" value="${record.vehicle.weight}" placeholder="Gross weight" pattern="^([0-9]+([.][0-9]*)?|[.][0-9]+)$" required>
								<div class="input-group-append">
									<span class="input-group-text">kg</span>
								</div>
							</div>
							
							<input type="number" class="form-control" name="passengers" min="0" value="${record.vehicle.passengers}" placeholder="Number of passengers" required>
							
							<div class="custom-control custom-checkbox padded-input">
								<input type="checkbox" class="custom-control-input" name="diesel" id="is-diesel" ${record.vehicle.diesel ? 'checked' : ''}>
								<label class="custom-control-label" for="is-diesel">Diesel-powered</label>
							</div>
								
							<input type="text" class="form-control" name="color" value="${record.vehicle.vehicleDetails.color}" placeholder="Color" required>
							
							<div class="input-group">
								<input type="text" class="form-control" name="cost" value="${record.vehicle.cost}" placeholder="Cost" pattern="^([0-9]+([.][0-9]*)?|[.][0-9]+)$" required>
								<div class="input-group-append">
									<span class="input-group-text">CAD</span>
								</div>
							</div>
							
							<div class="input-group">
								<input type="number" class="form-control" min="0" value="${record.vehicle.vehicleDetails.mileage}" name="mileage" placeholder="Mileage" required>
								<div class="input-group-append">
									<span class="input-group-text">km</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="form-group licence-plate-info">
					<div class="row">
						<div class="col"><h5>Licence Plate</h5></div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Plate Info</div>
						<div class="col">
							<input type="text" class="form-control" name="plate-number" value="${record.issuedPlate.plateNumber}" maxlength="8" placeholder="Number" required>
							<input type="text" class="form-control" name="plate-type"   value="${record.issuedPlate.plateType}" maxlength="16" placeholder="Type" required>
							
							<div class="input-group">
								<input type="text" class="form-control" name="renewal-fee" value="${record.issuedPlate.renewalFee}" placeholder="Renewal fee" pattern="^([0-9]+([.][0-9]*)?|[.][0-9]+)$" required>
								<div class="input-group-append">
									<span class="input-group-text">CAD</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Issue date</div>
						<div class="col">
							<input type="date" class="form-control" name="plate-issue-date" value="${record.issuedPlate.issueDate}"required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Expiry date</div>
						<div class="col">
							<input type="date" class="form-control" name="plate-expiry-date" value="${record.issuedPlate.expiryDate}"required>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold"></div>
						<div class="col">
							<div class="custom-control custom-checkbox padded-input">
								<input type="checkbox" class="custom-control-input" name="due" id="is-due" ${record.issuedPlate.due ? 'checked' : ''}>
								<label class="custom-control-label" for="is-due">Is due?</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-3 font-weight-bold">Branch</div>
						<div class="col">
							<input type="text" class="form-control" name="plate-branch" value="${record.issuedPlate.branch}" maxlength="20">
						</div>
					</div>
				</div>
				
				<button type="submit" class="btn btn-primary btn-block">Update</button>
			</form>
		</div>
	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	</body>
</html>