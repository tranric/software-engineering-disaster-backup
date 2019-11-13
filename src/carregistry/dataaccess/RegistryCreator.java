package carregistry.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carregistry.model.*;

public class RegistryCreator {
	String url      = "jdbc:mysql://localhost:3306/vrs?serverTimezone=UTC",
		   user     = "root",
		   password = "sqlpass";
	
	public int insertAddress(Address a) {
		int result = 0;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection(url, user, password);
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO AddressBook VALUES (?, ?, ?, ?, ?, ?)");
			
			stmt.setInt(1, a.getStreetNumber());
			stmt.setString(2, a.getStreetName());
			stmt.setString(3, a.getPostalCode());
			stmt.setString(4, a.getCity());
			stmt.setString(5, a.getProvince());
			stmt.setString(6, a.getUnit());
			
			result = stmt.executeUpdate();
			
			stmt.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		return result;
	}
	
	public int insertOwner(Owner o) {
		int result = 0;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection(url, user, password);
			String sql = "INSERT INTO Owners VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, o.getFirstName());
			stmt.setString(2, o.getMiddleInitial());
			stmt.setString(3, o.getLastName());
			stmt.setDate(4, o.getDateOfBirth());
			stmt.setString(5, o.getGender());
			stmt.setString(6, o.getEmail());
			stmt.setString(7, o.getPhone());
			stmt.setString(8, o.getDriverLicence());
			
			result = stmt.executeUpdate();
			
			stmt.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		return result;
	}
	
	public int insertVehicle(Vehicle v, VehicleDetails vd) {
		int result = 0;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection(url, user, password);
			String vehicleSql = "INSERT INTO VehicleModels VALUES (?,?,?,?,?,?,?,?,?,?)";
			String vehicleDetailsSql = "INSERT INTO VehicleDetails VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = connection.prepareStatement(vehicleSql);
			stmt.setString(1, v.getMake());
			stmt.setString(2, v.getModel());
			stmt.setString(3, v.getBodyStyle());
			stmt.setDouble(4, v.getWeight());
			stmt.setInt(5, v.getPassengers());
			stmt.setBoolean(6, v.isDiesel());
			stmt.setString(7, v.getModelType());
			stmt.setInt(8, v.getYear()); // Not sure about this one. It's listed as YEAR type in the SQL code.
			stmt.setDouble(9, v.getCost());
			stmt.setString(10, v.getId());
			
			result = stmt.executeUpdate();
			
			stmt = connection.prepareStatement(vehicleDetailsSql);
			stmt.setString(1, vd.getVin());
			stmt.setString(2, v.getOwner().getDriverLicence());
			stmt.setString(3, vd.getColor());
			stmt.setInt(4, vd.getMileage());
			stmt.setString(5, v.getId());
			
			result = stmt.executeUpdate();
			
			stmt.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		return result;
	}
	
	public int insertIssuedPlate(IssuedPlate ip) {
		int result = 0;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection(url, user, password);
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO IssuedPlate VALUES (?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, ip.getPlateNumber());
			stmt.setDate(2, ip.getIssueDate());
			stmt.setDate(3, ip.getExpiryDate());
			stmt.setString(4, ip.getPlateType());
			stmt.setString(5, ip.getRegId());
			stmt.setDouble(6, ip.getRenewalFee());
			stmt.setBoolean(7, ip.isDue());
			stmt.setString(8, ip.getBranch());
			
			result = stmt.executeUpdate();
			
			stmt.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		return result;
	}
	
	public int insertRegistry(VehicleRegistry vr) {
		int result = 0;
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection(url, user, password);
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO VehicleRegistry VALUES (?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, vr.getVehicle().getVehicleDetails().getVin());
			stmt.setString(2, vr.getOwner().getDriverLicence());
			stmt.setDate(3, vr.getRegisterDate());
			stmt.setDouble(4, vr.getTax());
			stmt.setString(5, vr.getRegId());
			stmt.setString(6, vr.getBranch());
			stmt.setString(7, vr.getLien());
			stmt.setString(8, vr.getInsuranceName());
			stmt.setDate(9, vr.getInsuranceExpiry());
			
			result = stmt.executeUpdate();
			
			stmt.close();
			connection.close();
		} catch (SQLException sqle) {
			System.out.println("SQL Exception!");
			System.out.printf("Code %d: %s\n\n", sqle.getErrorCode(), sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		return result;
	}
}
