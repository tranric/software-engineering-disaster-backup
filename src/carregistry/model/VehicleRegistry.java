package carregistry.model;

import java.io.Serializable;
import java.sql.Date;

public class VehicleRegistry implements Serializable {
	private String id, branch, lien, insuranceName;
	private Date registerDate, insuranceExpiry;
	private double tax;
	
	private Owner owner;
	private Vehicle vehicle;
	private IssuedPlate issuedPlate;
	
	public VehicleRegistry() {
		this.id              = "";
		this.insuranceName   = "";
		this.registerDate    = null;
		this.insuranceExpiry = null;
		this.tax             = 0.0;
		this.branch          = "";
		this.lien            = "";
		this.owner           = null;
		this.vehicle         = null;
		this.issuedPlate     = null;
	}
	
	public VehicleRegistry(String id, String insuranceName,
						   Date registerDate, Date insuranceExpiry, double tax,
						   String branch, String lien,
						   Owner owner, Vehicle vehicle, IssuedPlate issuedPlate) {
		this.id              = id;
		this.insuranceName   = insuranceName;
		this.registerDate    = registerDate;
		this.insuranceExpiry = insuranceExpiry;
		this.tax             = tax;
		this.branch          = branch;
		this.lien            = lien;
		this.owner           = owner;
		this.vehicle         = vehicle;
		this.issuedPlate     = issuedPlate;
	}
	
	public String      getId()              { return id; }
	public String      getInsuranceName()   { return insuranceName; }
	public Date        getRegisterDate()    { return registerDate; }
	public Date        getInsuranceExpiry() { return insuranceExpiry; }
	public double      getTax()             { return tax; }
	public String      getBranch()          { return branch; }
	public String      getLien()            { return lien; }
	public Owner       getOwner()           { return owner; }
	public Vehicle     getVehicle()         { return vehicle; }
	public IssuedPlate getIssuedPlate()     { return issuedPlate; }
	
	public void setId(String id)                         { this.id = id; }
	public void setInsuranceName(String insuranceName)   { this.insuranceName = insuranceName; }
	public void setRegisterDate(Date registerDate)       { this.registerDate = registerDate; }
	public void setInsuranceExpiry(Date insuranceExpiry) { this.insuranceExpiry = insuranceExpiry; }
	public void setTax(double tax)                       { this.tax = tax; }
	public void setBranch(String branch)                 { this.branch = branch; }
	public void setLien(String lien)                     { this.lien = lien; }
	public void setOwner(Owner owner)                    { this.owner = owner; }
	public void setVehicle(Vehicle vehicle)              { this.vehicle = vehicle; }
	public void setIssuedPlate(IssuedPlate issuedPlate)  { this.issuedPlate = issuedPlate; }
}
