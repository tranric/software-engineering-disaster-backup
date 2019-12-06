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

import org.mindrot.jbcrypt.BCrypt;

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
			User u = new LoginDAO().viewData(request.getParameter("id"));
			
			if (BCrypt.checkpw(request.getParameter("pwd"), u.getPassword())) {
				session.setAttribute("Login", u);
				session.setAttribute("Id", u.getId());
				session.setAttribute("Role", u.getRole());
				
				response.sendRedirect("HomePageInitController.do");	
			} else {
				request.setAttribute("loginError", "Sorry, the credentials you've entered were incorrect.");
				request.getRequestDispatcher("LoginPage.jsp").forward(request, response);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
