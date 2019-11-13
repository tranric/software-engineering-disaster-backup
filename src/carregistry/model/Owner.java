package carregistry.model;

import java.sql.Date;

public class Owner {
	private String firstName, middleInitial, lastName,
				   gender, email, phone, driverLicence;
	private Date dateOfBirth;
	private Address address;
	
	public Owner() {
		this.driverLicence = "";
		this.firstName     = "";
		this.middleInitial = "";
		this.lastName      = "";
		this.gender        = "";
		this.dateOfBirth   = null;
		this.email         = "";
		this.phone         = "";
		this.address       = null;
	}
	
	public Owner(String driverLicence, String firstName, String middleInitial, String lastName,
			     String gender, Date dateOfBirth, String email, String phone, Address address) {
		this.driverLicence = driverLicence;
		this.firstName     = firstName;
		this.middleInitial = middleInitial;
		this.lastName      = lastName;
		this.gender        = gender;
		this.dateOfBirth   = dateOfBirth;
		this.email         = email;
		this.phone         = phone;
		this.address       = address;
	}
	
	public String    getDriverLicence() { return driverLicence; }
	public String    getFirstName()     { return firstName; }
	public String    getMiddleInitial() { return middleInitial; }
	public String    getLastName()      { return lastName; }
	public String    getGender()        { return gender; }
	public Date      getDateOfBirth()   { return dateOfBirth; }
	public String    getEmail()         { return email; }
	public String    getPhone()         { return phone; }
	public Address   getAddress()       { return address; }
	
	public void setDriverLicence(String driverLicence) { this.driverLicence = driverLicence; }
	public void setFirstName(String firstName)         { this.firstName = firstName; }
	public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
	public void setLastName(String lastName)           { this.lastName = lastName; }
	public void setGender(String gender)               { this.gender = gender; }
	public void setDateOfBirth(Date dateOfBirth)       { this.dateOfBirth = dateOfBirth; }
	public void setEmail(String email)                 { this.email = email; }
	public void setPhone(String phone)                 { this.phone = phone; }
	public void setAddress(Address address)            { this.address = address; }
}
