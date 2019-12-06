package carregistry.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carregistry.model.VehicleRegistry;
import carregistry.dataaccess.RegistryDeleter;
import carregistry.model.ObjectEncoder;

@WebServlet("/RecordDeletionController.do")
public class RecordDeletionController extends HttpServlet {
	public RecordDeletionController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<VehicleRegistry> records = (ArrayList<VehicleRegistry>)request.getSession().getAttribute("records");
		String recordAsString = request.getParameter("recordAsString");
		VehicleRegistry vr = (VehicleRegistry) ObjectEncoder.decode(recordAsString);
		
		new RegistryDeleter().delete(records, vr);
		response.sendRedirect("HomePageInitController.do");
	}
}
