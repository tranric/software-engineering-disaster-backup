package carregistry.dataaccess;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carregistry.model.LoginRS;
import carregistry.model.DatabaseConnector;
import carregistry.model.Users;


public class LoginDAO {
	
	ResultSet rSet;
	
	
	public ArrayList<Users> viewData(String id, String pwd) throws Exception {
		
		String sql = "SELECT * from Login where Userid = '"+ id +"' AND Pass = '"+ pwd +"'";
		DatabaseConnector getConnection = new DatabaseConnector();
		try {
			 rSet = getConnection.getMySQLConnection().createStatement().executeQuery(sql);
		} 
		 catch (SQLException e) {
			System.out.println("SQL: Exeception Fired from LoginDAO-viewData()..");
			e.printStackTrace();
		}

		return new LoginRS().getUsers(rSet);
		
	}
}


