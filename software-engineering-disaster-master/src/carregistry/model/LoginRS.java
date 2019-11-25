package carregistry.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoginRS {
	Users Users;
	public ArrayList<Users> getUsers(ResultSet r) {
		
		
		ArrayList<Users> UsersList = new ArrayList<Users>();
		try {
			while(r.next()) {
				Users = new Users();
				Users.setId(r.getString(1));
				Users.setPassword(r.getString(2));
				Users.setRole(r.getString(3));
				UsersList.add(Users);
				}		
		} catch (SQLException e) {
			System.out.println("SQL Exception Fire from LoginRS()..");
			e.printStackTrace();
		}
		
		return UsersList;
		
	}

}
