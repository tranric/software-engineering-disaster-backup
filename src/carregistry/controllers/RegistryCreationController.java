package carregistry.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import carregistry.dataaccess.RegistryCreator;
import carregistry.model.*;

@WebServlet("/CreateRegistry.do")
public class RegistryCreationController extends HttpServlet {
	public RegistryCreationController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistryCreator rc = new RegistryCreator();
		
		// The database uses these primary keys as Varchars, so no autoincrementing :(
		String addressId = RandomStringUtils.randomAlphanumeric(10);
		String vehicleId = RandomStringUtils.randomAlphanumeric(10);
		String regId     = RandomStringUtils.randomAlphanumeric(20);
		boolean insuranceValidFilledIn = request.getParameter("reg-insurance-valid") != "";
		
		// A literal shit ton of data grabbing. Oh, boy...
		Address a          = new Address(addressId, request.getParameter("str-name"),
										 Integer.parseInt(request.getParameter("str-no")), request.getParameter("apt-no"),
										 request.getParameter("post-code"), request.getParameter("city"),
										 request.getParameter("province"));
		Owner o            = new Owner(request.getParameter("driver-licence"), request.getParameter("first-name"),
				 					   request.getParameter("middle-initial"), request.getParameter("last-name"), 
				 					   request.getParameter("gender-radio"), Date.valueOf(request.getParameter("owner-dob")),
				 					   request.getParameter("owner-email"), request.getParameter("owner-phone"),
				 					   a);
		VehicleDetails vd  = new VehicleDetails(request.getParameter("vin"), vehicleId, request.getParameter("driver-licence"),
												request.getParameter("color"), Integer.parseInt(request.getParameter("mileage")));
		Vehicle v          = new Vehicle(vehicleId, request.getParameter("make"),
										 request.getParameter("model"), Integer.parseInt(request.getParameter("made")),
										 Double.parseDouble(request.getParameter("weight")),
										 Double.parseDouble(request.getParameter("cost")),
										 Integer.parseInt(request.getParameter("passengers")),
										 Boolean.parseBoolean(request.getParameter("diesel")),
										 request.getParameter("model-type"),
										 request.getParameter("body-style"),
										 vd, o);
		IssuedPlate ip     = new IssuedPlate(request.getParameter("plate-number"), request.getParameter("plate-type"),
											 Date.valueOf(request.getParameter("plate-issue-date")),
											 Date.valueOf(request.getParameter("plate-expiry-date")),
											 Boolean.parseBoolean(request.getParameter("due")),
											 Double.parseDouble(request.getParameter("renewal-fee")),
											 request.getParameter("plate-branch"), regId);
		VehicleRegistry vr = new VehicleRegistry(regId, request.getParameter("reg-insurance-name"),
												 Date.valueOf(request.getParameter("reg-issue-date")),
												 insuranceValidFilledIn ? Date.valueOf(request.getParameter("reg-insurance-valid")) : null,
												 Double.parseDouble(request.getParameter("reg-fee")),
												 request.getParameter("reg-branch"),
												 request.getParameter("reg-lien"),
												 o, v, ip);
		
		try {
			rc.insertAddress(a);
			rc.insertOwner(o);
			rc.insertVehicle(v, vd);
			rc.insertRegistry(vr);
			rc.insertIssuedPlate(ip);
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		response.sendRedirect("HomePageInitController.do");
	}
}
