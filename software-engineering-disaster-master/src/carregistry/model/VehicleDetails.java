package carregistry.model;

public class VehicleDetails {
	private String vin, color;
	private int mileage;
	
	public VehicleDetails() {
		this.vin     = "";
		this.color   = "";
		this.mileage = 0;
	}
	
	public VehicleDetails(String vin, String color, int mileage) {
		this.vin     = vin;
		this.color   = color;
		this.mileage = mileage;
	}
	
	public String getVin()     { return vin; }
	public String getColor()   { return color; }
	public int    getMileage() { return mileage; }
	
	public void setVin(String vin)      { this.vin = vin; }
	public void setColor(String color)  { this.color = color; }
	public void setMileage(int mileage) { this.mileage = mileage; }
}
