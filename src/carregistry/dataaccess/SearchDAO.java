package carregistry.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carregistry.dataaccess.CreateVehicleBean;
import carregistry.model.DatabaseConnector;
import carregistry.model.Vehicle;

public class SearchDAO {
	public ArrayList<Vehicle> viewData(String make, String model, String passenger, int year) throws Exception {
		ResultSet rSet = null;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VehicleModels WHERE Model = ? AND Passengers = ? AND Year = ? AND Make = ?");
			
			stmt.setString(1, model);
			stmt.setString(2, passenger);
			stmt.setInt(3, year);
			stmt.setString(4, make);
			
			rSet = stmt.executeQuery();
		} 
		 catch (SQLException e) {
			System.out.println("SQL: Exeception Fired from viewData()..");
			e.printStackTrace();
		}

		return new CreateVehicleBean().getVehicle(rSet);
	}
}


