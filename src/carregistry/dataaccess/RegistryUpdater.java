package carregistry.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carregistry.model.Address;
import carregistry.model.DatabaseConnector;
import carregistry.model.IssuedPlate;
import carregistry.model.Owner;
import carregistry.model.Vehicle;
import carregistry.model.VehicleDetails;
import carregistry.model.VehicleRegistry;

public class RegistryUpdater {
	private VehicleRegistry currentRecord;
	
	public RegistryUpdater(VehicleRegistry currentRecord) {
		this.currentRecord = currentRecord;
	}
	
	public VehicleRegistry getCurrentRecord() { return currentRecord; }
	public void setCurrentRecord(VehicleRegistry currentRecord) { this.currentRecord = currentRecord; }
	
	public int updateAddress(Address a) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement(
				  "UPDATE AddressBook SET "
				+ "StreetNumber = ?, "
				+ "StreetName = ?, "
				+ "PostalCode = ?, "
				+ "City = ?, "
				+ "Province = ?, "
				+ "Unit = ? "
				+ "WHERE AddressID = ?"
		);
		
		stmt.setInt(1, a.getStreetNumber());
		stmt.setString(2, a.getStreetName());
		stmt.setString(3, a.getPostalCode());
		stmt.setString(4, a.getCity());
		stmt.setString(5, a.getProvince());
		stmt.setString(6, a.getUnit());
		stmt.setString(7, currentRecord.getOwner().getAddress().getId());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
	
	public int updateOwner(Owner o) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement(
				  "UPDATE Owners SET "
				+ "FirstName = ?, "
				+ "MiddleInitial = ?, "
				+ "LastName = ?, "
				+ "DateOfBirth = ?, "
				+ "Gender = ?, "
				+ "Email = ?, "
				+ "Phone = ?, "
				+ "DriversLicID = ? "
				+ "WHERE DriversLicID = ?"
		);
		
		stmt.setString(1, o.getFirstName());
		stmt.setString(2, o.getMiddleInitial());
		stmt.setString(3, o.getLastName());
		stmt.setDate(4, o.getDateOfBirth());
		stmt.setString(5, o.getGender());
		stmt.setString(6, o.getEmail());
		stmt.setString(7, o.getPhone());
		stmt.setString(8, o.getDriverLicence());
		stmt.setString(9, currentRecord.getOwner().getDriverLicence());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
	
	public int updateVehicle(Vehicle v, VehicleDetails vd) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		String vehicleSql = "UPDATE VehicleModels SET "
						  + "Make = ?, "
						  + "Model = ?, "
						  + "BodyStyle = ?, "
						  + "Weight = ?, "
						  + "Passengers = ?, "
						  + "Diesel = ?, "
						  + "Modeltype = ?, "
						  + "Year = ?, "
						  + "Cost = ? "
						  + "WHERE ModelID = ?";
		
		String vehicleDetailsSql = "UPDATE VehicleDetails SET "
								 + "VIN = ?, "
								 + "Colour = ?, "
								 + "Mileage = ? "
								 + "WHERE ModelID = ?";
		
		PreparedStatement stmt = connection.prepareStatement(vehicleSql);
		stmt.setString(1, v.getMake());
		stmt.setString(2, v.getModel());
		stmt.setString(3, v.getBodyStyle());
		stmt.setDouble(4, v.getWeight());
		stmt.setInt(5, v.getPassengers());
		stmt.setBoolean(6, v.isDiesel());
		stmt.setString(7, v.getModelType());
		stmt.setInt(8, v.getYear());
		stmt.setDouble(9, v.getCost());
		stmt.setString(10, currentRecord.getVehicle().getId());
		
		result = stmt.executeUpdate();
		
		stmt = connection.prepareStatement(vehicleDetailsSql);
		stmt.setString(1, vd.getVin());
		stmt.setString(2, vd.getColor());
		stmt.setInt(3, vd.getMileage());
		stmt.setString(4, currentRecord.getVehicle().getId());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
	
	public int updateIssuedPlate(IssuedPlate ip) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement(
				  "UPDATE IssuedPlates SET "
				+ "PlateNumber = ?, "
				+ "IssuedOn = ?, "
				+ "ExpiresOn = ?, "
				+ "PlateType = ?, "
				+ "RenewalFee = ?, "
				+ "IsDue = ?, "
				+ "Branch = ? "
				+ "WHERE PlateNumber = ?"
		);
		
		stmt.setString(1, ip.getPlateNumber());
		stmt.setDate(2, ip.getIssueDate());
		stmt.setDate(3, ip.getExpiryDate());
		stmt.setString(4, ip.getPlateType());
		stmt.setDouble(5, ip.getRenewalFee());
		stmt.setBoolean(6, ip.isDue());
		stmt.setString(7, ip.getBranch());
		stmt.setString(8, currentRecord.getIssuedPlate().getPlateNumber());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
	
	public int updateRegistry(VehicleRegistry vr) throws SQLException, ClassNotFoundException {
		int result = 0;
		
		Connection connection = new DatabaseConnector().getMySQLConnection();
		PreparedStatement stmt = connection.prepareStatement(
				  "UPDATE VehicleRegistry SET "
				+ "RegisteredOn = ?, "
				+ "Taxes = ?, "
				+ "Branch = ?, "
				+ "Lien = ?, "
				+ "InsuranceName = ?, "
				+ "InsuranceValidity = ? "
				+ "WHERE RegistrationID = ?"
		);
		
		stmt.setDate(1, vr.getRegisterDate());
		stmt.setDouble(2, vr.getTax());
		stmt.setString(3, vr.getBranch());
		stmt.setString(4, vr.getLien());
		stmt.setString(5, vr.getInsuranceName());
		stmt.setDate(6, vr.getInsuranceExpiry());
		stmt.setString(7, currentRecord.getId());
		
		result = stmt.executeUpdate();
		
		stmt.close();
		connection.close();
		
		return result;
	}
}
