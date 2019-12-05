package carregistry.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carregistry.dataaccess.SearchDAO;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("vehicle", new SearchDAO().viewData(request.getParameter("makename"), request.getParameter("modelname"), 
																     request.getParameter("passname"), 
																     Integer.parseInt(request.getParameter("yearname"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
}