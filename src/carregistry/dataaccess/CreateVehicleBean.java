package carregistry.dataaccess;

import java.sql.ResultSet;
import carregistry.model.Vehicle;
import java.sql.SQLException;
import java.util.ArrayList;


public class CreateVehicleBean {
	public ArrayList<Vehicle> getVehicle(ResultSet r) {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			while(r.next()) {
				Vehicle v = new Vehicle();
				
				v.setId(r.getString(10));         
				v.setMake(r.getString(1));          
				v.setModel(r.getString(2));         
				v.setYear(r.getInt(8));           
				v.setWeight(r.getDouble(4));        
				v.setCost(r.getDouble(9));          
				v.setPassengers(r.getInt(5));  
				v.setDiesel(r.getBoolean(6));        
				v.setModelType(r.getString(7));   
				v.setBodyStyle(r.getString(3));      
				//v.setVehicleDetails(); 
				//v.setOwner();
				
				vehicleList.add(v);
			}		
		} catch (SQLException e) {
			System.out.println("SQL Exception Fire from getVehicleBean()..");
			e.printStackTrace();
		}
		
		return vehicleList;
	}
}
