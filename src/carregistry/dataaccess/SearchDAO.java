package carregistry.dataaccess;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carregistry.dataaccess.CreateVehicleBean;
import carregistry.model.DatabaseConnector;
import carregistry.model.Vehicle;


public class SearchDAO {
	public ArrayList<Vehicle> viewData(String make, String model, String passenger, String year) throws Exception {
		ResultSet rSet = null;
		
		String sql = "SELECT * from VehicleModels where Model = '"+ model +"' AND Passengers = '"+ passenger +"' AND Year = '"+ year +"' AND Make = '"+ make +"'";  
		DatabaseConnector getConnection = new DatabaseConnector();
		try {
			 rSet = getConnection.getMySQLConnection().createStatement().executeQuery(sql);
		} 
		 catch (SQLException e) {
			System.out.println("SQL: Exeception Fired from viewData()..");
			e.printStackTrace();
		}

		return new CreateVehicleBean().getVehicle(rSet);
		
	}
}


