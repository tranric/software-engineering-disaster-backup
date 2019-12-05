package carregistry.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carregistry.model.*;

public class RegistryCreator {
	public int insertAddress(Address a) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO AddressBook VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, a.getId());
		stmt.setInt(2, a.getStreetNumber());
		stmt.setString(3, a.getStreetName());
		stmt.setString(4, a.getPostalCode());
		stmt.setString(5, a.getCity());
		stmt.setString(6, a.getProvince());
		stmt.setString(7, a.getUnit());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
	
	public int insertOwner(Owner o) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		String ownerSql = "INSERT INTO Owners VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String ownerAddressSql = "INSERT INTO OwnerAddress VALUES (?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(ownerSql);
		stmt.setString(1, o.getFirstName());
		stmt.setString(2, o.getMiddleInitial());
		stmt.setString(3, o.getLastName());
		stmt.setDate(4, o.getDateOfBirth());
		stmt.setString(5, o.getGender());
		stmt.setString(6, o.getEmail());
		stmt.setString(7, o.getPhone());
		stmt.setString(8, o.getDriverLicence());
		
		result = stmt.executeUpdate();
		
		stmt = connection.prepareStatement(ownerAddressSql);
		stmt.setString(1, o.getDriverLicence());
		stmt.setString(2, o.getAddress().getId());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
	
	public int insertVehicle(Vehicle v, VehicleDetails vd) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
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
		
		return result;
	}
	
	public int insertIssuedPlate(IssuedPlate ip) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO IssuedPlates VALUES (?,?,?,?,?,?,?,?)");
		
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
		
		return result;
	}
	
	public int insertRegistry(VehicleRegistry vr) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO VehicleRegistry VALUES (?,?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, vr.getVehicle().getVehicleDetails().getVin());
		stmt.setString(2, vr.getOwner().getDriverLicence());
		stmt.setDate(3, vr.getRegisterDate());
		stmt.setDouble(4, vr.getTax());
		stmt.setString(5, vr.getId());
		stmt.setString(6, vr.getBranch());
		stmt.setString(7, vr.getLien());
		stmt.setString(8, vr.getInsuranceName());
		stmt.setDate(9, vr.getInsuranceExpiry());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
}
