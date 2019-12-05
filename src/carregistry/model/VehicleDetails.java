package carregistry.model;

public class VehicleDetails {
	private String vin, color, driverLicense, modelId;
	private int mileage;
	
	public VehicleDetails() {
		this.vin           = "";
		this.modelId       = "";
		this.driverLicense = "";
		this.color         = "";
		this.mileage       = 0;
	}
	
	public VehicleDetails(String vin, String modelId, String driverLicense, String color, int mileage) {
		this.vin           = vin;
		this.modelId       = modelId;
		this.driverLicense = driverLicense;
		this.color         = color;
		this.mileage       = mileage;
	}
	
	public String getVin()           { return vin; }
	public String getModelId()       { return modelId; }
	public String getDriverLicense() { return driverLicense; }
	public String getColor()         { return color; }
	public int    getMileage()       { return mileage; }
	
	public void setVin(String vin)                     { this.vin = vin; }
	public void setModelId(String modelId)             { this.modelId = modelId; }
	public void setDriverLicense(String driverLicense) { this.driverLicense = driverLicense; }
	public void setColor(String color)                 { this.color = color; }
	public void setMileage(int mileage)                { this.mileage = mileage; }
}
