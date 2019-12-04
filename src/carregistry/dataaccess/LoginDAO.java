package carregistry.dataaccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carregistry.model.LoginRS;
import carregistry.model.DatabaseConnector;
import carregistry.model.User;


public class LoginDAO {
	
	
	public ArrayList<User> viewData(String id, String pwd) throws Exception {
		ResultSet rSet = null;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Login WHERE Userid = ? AND Pass = ?");
			
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			
			rSet = stmt.executeQuery();
		} 
		 catch (SQLException e) {
			System.out.println("SQL: Exeception Fired from LoginDAO-viewData()..");
			e.printStackTrace();
		}

		return new LoginRS().getUsers(rSet);
	}
}


