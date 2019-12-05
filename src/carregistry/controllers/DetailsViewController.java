package carregistry.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carregistry.model.VehicleRegistry;

@WebServlet("/ViewDetails.do")
public class DetailsViewController extends HttpServlet {
	public DetailsViewController() { super(); }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<VehicleRegistry> records = (ArrayList<VehicleRegistry>)request.getSession().getAttribute("records");
		
		request.setAttribute("record", records.get(Integer.parseInt(request.getParameter("record-index"))));
		request.getRequestDispatcher("Details.jsp").forward(request, response);
	}
}
