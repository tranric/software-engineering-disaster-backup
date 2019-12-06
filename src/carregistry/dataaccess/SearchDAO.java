package carregistry.dataaccess;

import java.sql.Date;
import java.util.ArrayList;
import java.util.stream.Collectors;
import carregistry.model.VehicleRegistry;

public class SearchDAO {
	public ArrayList<VehicleRegistry> viewData(ArrayList<VehicleRegistry> records,
											   String vin, String firstName, String initial, String lastName,
											   Date regDate) {
		return (ArrayList<VehicleRegistry>)
			    records.stream().filter(record -> !vin.equals("") ? record.getVehicle().getVehicleDetails().getVin().equalsIgnoreCase(vin) : true)
			    				.filter(record -> !firstName.equals("") ? record.getOwner().getFirstName().equalsIgnoreCase(firstName) : true)
			    				.filter(record -> !initial.equals("") ? record.getOwner().getMiddleInitial().equalsIgnoreCase(initial) : true)
			    				.filter(record -> !lastName.equals("") ? record.getOwner().getLastName().equalsIgnoreCase(lastName) : true)
			    				.filter(record -> regDate != null ? record.getRegisterDate().compareTo(regDate) == 0 : true)
			    				.collect(Collectors.toList());
	}
}


