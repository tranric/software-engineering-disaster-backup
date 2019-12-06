package carregistry.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginRS {
	public User getUsers(ResultSet r) {
		User u = new User();
		
		try {
			if(r.first()) {
				u.setId(r.getString(1));
				u.setPassword(r.getString(2));
				u.setRole(r.getString(3));
			}		
		} catch (SQLException e) {
			System.out.println("SQL Exception Fire from LoginRS()..");
			e.printStackTrace();
		}
		
		return u;
	}

}
