package carregistry.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carregistry.model.VehicleRegistry;
import carregistry.model.ObjectEncoder;

@WebServlet("/PrepRecordUpdateController.do")
public class PrepRecordUpdateController extends HttpServlet {
	public PrepRecordUpdateController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String record = request.getParameter("recordAsString");
		VehicleRegistry vr = (VehicleRegistry) ObjectEncoder.decode(record);
		
		request.setAttribute("record", vr);
		request.setAttribute("currentRecordAsString", ObjectEncoder.encode(vr));
		request.getRequestDispatcher("UpdateRecord.jsp").forward(request, response);
	}
}
