package carregistry.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carregistry.dataaccess.RegistryUpdater;
import carregistry.model.Address;
import carregistry.model.IssuedPlate;
import carregistry.model.ObjectEncoder;
import carregistry.model.Owner;
import carregistry.model.Vehicle;
import carregistry.model.VehicleDetails;
import carregistry.model.VehicleRegistry;

/**
 * Servlet implementation class RegistryUpdateController
 */
@WebServlet("/UpdateRegistry.do")
public class RegistryUpdateController extends HttpServlet {
	public RegistryUpdateController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentRecordAsString = request.getParameter("currentRecordAsString");
		VehicleRegistry currentRecord = (VehicleRegistry) ObjectEncoder.decode(currentRecordAsString);
		RegistryUpdater ru = new RegistryUpdater(currentRecord);
		
		String addressId = currentRecord.getOwner().getAddress().getId();
		String vehicleId = currentRecord.getVehicle().getId();
		String regId     = currentRecord.getId();
		boolean insuranceValidFilledIn = request.getParameter("reg-insurance-valid") != "";
		
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
										 request.getParameter("diesel") != null,
										 request.getParameter("model-type"),
										 request.getParameter("body-style"),
										 vd, o);
		IssuedPlate ip     = new IssuedPlate(request.getParameter("plate-number"), request.getParameter("plate-type"),
											 Date.valueOf(request.getParameter("plate-issue-date")),
											 Date.valueOf(request.getParameter("plate-expiry-date")),
											 request.getParameter("due") != null,
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
			ru.updateAddress(a);
			ru.updateOwner(o);
			ru.updateVehicle(v, vd);
			ru.updateRegistry(vr);
			ru.updateIssuedPlate(ip);
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		response.sendRedirect("HomePageInitController.do");
	}
}
