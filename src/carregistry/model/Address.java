package carregistry.model;

import java.io.Serializable;

public class Address implements Serializable {
	private String id, streetName, postalCode, city, province, unit;
	private int streetNumber;
	
	public Address() {
		this.id           = "";
		this.streetName   = "";
		this.streetNumber = 0;
		this.unit         = "";
		this.postalCode   = "";
		this.city         = "";
		this.province     = "";
	}
	
	public Address(String id, String streetName, int streetNumber, String unit, String postalCode, String city, String province) {
		this.id           = id;
		this.streetName   = streetName;
		this.streetNumber = streetNumber;
		this.unit         = unit;
		this.postalCode   = postalCode;
		this.city         = city;
		this.province     = province;
	}
	
	public String getId()           { return id; }
	public String getStreetName()   { return streetName; }
	public int    getStreetNumber() { return streetNumber; }
	public String getUnit()         { return unit; }
	public String getPostalCode()   { return postalCode; }
	public String getCity()         { return city; }
	public String getProvince()     { return province; }
	
	public void setId(String id)                  { this.id = id; }
	public void setStreetName(String streetName)  { this.streetName = streetName; }
	public void setStreetNumber(int streetNumber) { this.streetNumber = streetNumber; }
	public void setUnit(String unit)              { this.unit = unit; }
	public void setPostalCode(String postalCode)  { this.postalCode = postalCode; }
	public void setCity(String city)              { this.city = city; }
	public void setProvince(String province)      { this.province = province; }
}
