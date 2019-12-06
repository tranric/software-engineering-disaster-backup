package carregistry.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import carregistry.model.DatabaseConnector;
import carregistry.model.VehicleRegistry;

public class RegistryDeleter {
	public void delete(ArrayList<VehicleRegistry> records, VehicleRegistry vr) {
		try {
			String[] commands = {
					"DELETE FROM VehicleRegistry WHERE RegistrationID = ?",
					"DELETE FROM Owners WHERE DriversLicID = ?",
					"DELETE FROM AddressBook WHERE AddressID = ?",
					"DELETE FROM VehicleModels WHERE ModelID = ?",
			};
			
			Connection connection = new DatabaseConnector().getMySQLConnection();
			PreparedStatement stmt = connection.prepareStatement(commands[0]);
			stmt.setString(1, vr.getId());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement(commands[1]);
			stmt.setString(1, vr.getOwner().getDriverLicence());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement(commands[2]);
			stmt.setString(1, vr.getOwner().getAddress().getId());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement(commands[3]);
			stmt.setString(1, vr.getVehicle().getId());
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
			
			records.remove(vr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
