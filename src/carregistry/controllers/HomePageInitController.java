package carregistry.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carregistry.dataaccess.HomePageDataInitializer;

/**
 * Servlet implementation class HomePageInitController
 */
@WebServlet("/HomePageInitController.do")
public class HomePageInitController extends HttpServlet {
    public HomePageInitController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		HomePageDataInitializer init = new HomePageDataInitializer();
		
		session.setAttribute("records", init.getRecords());
		response.sendRedirect("HomePage.jsp");
	}
}
