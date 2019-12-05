package carregistry.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import carregistry.model.*;

public class HomePageDataInitializer {
	public ArrayList<VehicleRegistry> getRecords() {
		ArrayList<VehicleRegistry> records = new ArrayList<>();
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VehicleRegistry");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				VehicleRegistry vr = new VehicleRegistry();
				vr.setId(rs.getString(5));
				vr.setInsuranceName(rs.getString(8));
				vr.setRegisterDate(rs.getDate(3));
				vr.setInsuranceExpiry(rs.getDate(9));
				vr.setTax(rs.getDouble(4));
				vr.setBranch(rs.getString(6));
				vr.setLien(rs.getString(7));
				
				vr.setOwner(getOwner(rs.getString(2)));
				vr.setVehicle(getVehicle(rs.getString(1), vr.getOwner()));
				vr.setIssuedPlate(getIssuedPlate(rs.getString(5)));
				
				records.add(vr);
			}
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return records;
	}
	
	private IssuedPlate getIssuedPlate(String regId) {
		IssuedPlate ip = new IssuedPlate();
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM IssuedPlates WHERE RegistrationID = ?");
			
			stmt.setString(1, regId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				ip.setPlateNumber(rs.getString(1));
				ip.setIssueDate(rs.getDate(2));
				ip.setExpiryDate(rs.getDate(3));
				ip.setPlateType(rs.getString(4));
				ip.setRegId(regId);
				ip.setRenewalFee(rs.getDouble(6));
				ip.setDue(rs.getBoolean(7));
				ip.setBranch(rs.getString(8));
			}
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ip;
	}
	
	private Owner getOwner(String driverLicenseId) {
		Owner o = new Owner();
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Owners WHERE DriversLicID = ?");
			
			stmt.setString(1, driverLicenseId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				o.setDriverLicence(driverLicenseId);
				o.setFirstName(rs.getString(1));
				o.setMiddleInitial(rs.getString(2));
				o.setLastName(rs.getString(3));
				o.setDateOfBirth(rs.getDate(4));
				o.setGender(rs.getString(5));
				o.setEmail(rs.getString(6));
				o.setPhone(rs.getString(7));
			}
			
			stmt = connection.prepareStatement("SELECT AddressID FROM OwnerAddress WHERE DriversLicID = ?");
			stmt.setString(1, driverLicenseId);
			
			rs = stmt.executeQuery();
			
			String addressId = "";
			while (rs.next()) addressId = rs.getString(1);
			
			o.setAddress(getAddress(addressId));
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return o;
	}
	
	private VehicleDetails getVehicleDetails(String vin) {
		VehicleDetails vd = new VehicleDetails();
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VehicleDetails WHERE VIN = ?");
			
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				vd.setVin(rs.getString(1));
				vd.setDriverLicense(rs.getString(2));
				vd.setColor(rs.getString(3));
				vd.setMileage(rs.getInt(4));
				vd.setModelId(rs.getString(5));
			}
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vd;
	}
	
	private Vehicle getVehicle(String vin, Owner o) {
		VehicleDetails vd = getVehicleDetails(vin);
		Vehicle v = new Vehicle();
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VehicleModels WHERE ModelID = ?");
			
			stmt.setString(1, vd.getModelId());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				v.setMake(rs.getString(1));
				v.setModel(rs.getString(2));
				v.setBodyStyle(rs.getString(3));
				v.setWeight(rs.getDouble(4));
				v.setPassengers(rs.getInt(5));
				v.setDiesel(rs.getBoolean(6));
				v.setModelType(rs.getString(7));
				v.setYear(rs.getInt(8));
				v.setCost(rs.getDouble(9));
				v.setId(rs.getString(10));
			}
			
			v.setVehicleDetails(vd);
			v.setOwner(o);
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
	private Address getAddress(String addressId) {
		Address a = new Address();
		
		try {
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM AddressBook WHERE AddressID = ?");
			
			stmt.setString(1, addressId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				a.setId(addressId);
				a.setStreetNumber(rs.getInt(2));
				a.setStreetName(rs.getString(3));
				a.setPostalCode(rs.getString(4));
				a.setCity(rs.getString(5));
				a.setProvince(rs.getString(6));
				a.setUnit(rs.getString(7));
			}
			
			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
}
