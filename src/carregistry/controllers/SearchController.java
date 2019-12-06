package carregistry.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carregistry.dataaccess.SearchDAO;
import carregistry.model.VehicleRegistry;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean regDateIsEmpty = request.getParameter("reg-date").equals("");
		
		try {
			request.setAttribute("searchResult",
								 new SearchDAO().viewData((ArrayList<VehicleRegistry>)session.getAttribute("records"),
										 				  request.getParameter("vin"), request.getParameter("first-name"),
										 				  request.getParameter("middle-initial"), request.getParameter("last-name"),
										 				  !regDateIsEmpty ? Date.valueOf(request.getParameter("reg-date")) : null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Search.jsp").forward(request, response);
	}
}