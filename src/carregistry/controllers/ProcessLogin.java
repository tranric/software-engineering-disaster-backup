package carregistry.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carregistry.model.User;

import carregistry.model.DatabaseConnector;
import carregistry.dataaccess.LoginDAO;

@WebServlet("/ProcessLogin")
public class ProcessLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			ArrayList<User> Usercheck = new LoginDAO().viewData(
					request.getParameter("id"), request.getParameter("pwd"));
			
			if (Usercheck.size() == 1) {
				session.setAttribute("Login", Usercheck);
				session.setAttribute("Id", Usercheck.get(0).getId());
				session.setAttribute("Role", Usercheck.get(0).getRole());
				
				response.sendRedirect("HelloPage.jsp");	
			} else {
				session.setAttribute("loginError", "Sorry, the credentials you've entered were incorrect.");
				response.sendRedirect("LoginPage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
