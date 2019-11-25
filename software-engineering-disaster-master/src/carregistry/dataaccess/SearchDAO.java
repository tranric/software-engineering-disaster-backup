package carregistry.dataaccess;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carregistry.model.CreateVehicleBean;
import carregistry.model.DatabaseConnector;
import carregistry.model.Vehicle;


public class SearchDAO {
	
	ResultSet rSet;
	
	
	public ArrayList<Vehicle> viewData(String model, String passenger, String year, String colour) throws Exception {
		
		String sql = "SELECT * from CarReg where Model = '"+ model +"' AND Passengers = '"+ passenger +"' AND YearReg = '"+ year +"' AND ModelColour '"+ colour +"' ";
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


