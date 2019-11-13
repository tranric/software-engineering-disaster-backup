package carregistry.model;

public class Address {
	private String streetName, postalCode, city, province, unit;
	private int id, streetNumber;
	
	public Address() {
		this.id           = 0;
		this.streetName   = "";
		this.streetNumber = 0;
		this.unit         = "";
		this.postalCode   = "";
		this.city         = "";
		this.province     = "";
	}
	
	public Address(int id, String streetName, int streetNumber, String unit, String postalCode, String city, String province) {
		this.id           = id;
		this.streetName   = streetName;
		this.streetNumber = streetNumber;
		this.unit         = unit;
		this.postalCode   = postalCode;
		this.city         = city;
		this.province     = province;
	}
	
	public int    getId()           { return id; }
	public String getStreetName()   { return streetName; }
	public int    getStreetNumber() { return streetNumber; }
	public String getUnit()         { return unit; }
	public String getPostalCode()   { return postalCode; }
	public String getCity()         { return city; }
	public String getProvince()     { return province; }
	
	public void setId(int id)                     { this.id = id; }
	public void setStreetName(String streetName)  { this.streetName = streetName; }
	public void setStreetNumber(int streetNumber) { this.streetNumber = streetNumber; }
	public void setUnit(String unit)              { this.unit = unit; }
	public void setPostalCode(String postalCode)  { this.postalCode = postalCode; }
	public void setCity(String city)              { this.city = city; }
	public void setProvince(String province)      { this.province = province; }
}
