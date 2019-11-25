package carregistry.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CreateVehicleBean {
	Vehicle vehicle;
	public ArrayList<Vehicle> getVehicle(ResultSet r) {
		
		
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			while(r.next()) {
				vehicle = new Vehicle();
				vehicle.setModel(r.getString(1));
				vehicle.setPassengers(r.getInt(2));
				vehicle.setYear(r.getInt(3));
				//vehicle.setColour(r.getString(4));
				vehicleList.add(vehicle);
				}		
		} catch (SQLException e) {
			System.out.println("SQL Exception Fire from getVehicleBean()..");
			e.printStackTrace();
		}
		
		return vehicleList;
		
	}

}
