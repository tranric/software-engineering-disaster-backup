package carregistry.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginRS {
	public ArrayList<User> getUsers(ResultSet r) {
		ArrayList<User> UsersList = new ArrayList<User>();
		try {
			while(r.next()) {
				User u = new User();
				
				u.setId(r.getString(1));
				u.setPassword(r.getString(2));
				u.setRole(r.getString(3));
				
				UsersList.add(u);
			}		
		} catch (SQLException e) {
			System.out.println("SQL Exception Fire from LoginRS()..");
			e.printStackTrace();
		}
		
		return UsersList;
	}

}
