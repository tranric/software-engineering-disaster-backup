package carregistry.model;

public class Vehicle {
	private String id, make, model, bodyStyle, modelType;
	private boolean diesel;
	private double weight, cost;
	private int year, passengers;
	private VehicleDetails details;
	private Owner owner;
	
	public Vehicle() {
		this.id         = "";
		this.make       = "";
		this.model      = "";
		this.year       = 0;
		this.weight     = 0.0;
		this.cost       = 0.0;
		this.passengers = 0;
		this.diesel     = false;
		this.modelType  = "";
		this.bodyStyle  = "";
		this.details    = null;
		this.owner      = null;
	}
	
	public Vehicle(String id, String make, String model, int year, double weight, double cost, int passengers,
				   boolean diesel, String modelType, String bodyStyle, VehicleDetails details,
				   Owner owner) {
		this.id         = id;
		this.make       = make;
		this.model      = model;
		this.year       = year;
		this.weight     = weight;
		this.cost       = cost;
		this.passengers = passengers;
		this.diesel     = diesel;
		this.modelType  = model;
		this.bodyStyle  = bodyStyle;
		this.details    = details;
		this.owner      = owner;
	}
	
	public String         getId()             { return id; }
	public String         getMake()           { return make; }
	public String         getModel()          { return model; }
	public int            getYear()           { return year; }
	public double         getWeight()         { return weight; }
	public double         getCost()           { return cost; }
	public int            getPassengers()     { return passengers; }
	public boolean        isDiesel()          { return diesel; }
	public String         getModelType()      { return modelType; }
	public String         getBodyStyle()      { return bodyStyle; }
	public VehicleDetails getVehicleDetails() { return details; }
	public Owner          getOwner()          { return owner; }
	
	public void setId(String id)                          { this.id = id; }
	public void setMake(String make)                      { this.make = make; }
	public void setModel(String model)                    { this.model = model; }
	public void setYear(int year)                         { this.year = year; }
	public void setWeight(double weight)                  { this.weight = weight; }
	public void setCost(double cost)                      { this.cost = cost; }
	public void setPassengers(int passengers)             { this.passengers = passengers; }
	public void setDiesel(boolean diesel)                 { this.diesel = diesel; }
	public void setModelType(String modelType)            { this.modelType = modelType; }
	public void setBodyStyle(String bodyStyle)            { this.bodyStyle = bodyStyle; }
	public void setVehicleDetails(VehicleDetails details) { this.details = details; }
	public void setOwner(Owner owner)                     { this.owner = owner; }
}
