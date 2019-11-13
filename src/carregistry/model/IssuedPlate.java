package carregistry.model;

import java.sql.Date;

public class IssuedPlate {
	private String plateNumber, plateType, branch, regId;
	private boolean due;
	private Date issueDate, expiryDate;
	private double renewalFee;
	
	public IssuedPlate() {
		this.plateNumber = "";
		this.plateType   = "";
		this.issueDate   = null;
		this.expiryDate  = null;
		this.due         = false;
		this.renewalFee  = 0.0;
		this.branch      = "";
		this.regId       = "";
	}
	
	public IssuedPlate(String plateNumber, String plateType, Date issueDate, Date expiryDate,
					   boolean due, double renewalFee, String branch, String regId) {
		this.plateNumber = plateNumber;
		this.plateType   = plateType;
		this.issueDate   = issueDate;
		this.expiryDate  = expiryDate;
		this.due         = due;
		this.renewalFee  = renewalFee;
		this.branch      = branch;
		this.regId       = regId;
	}
	
	public String    getPlateNumber() { return plateNumber; }
	public String    getPlateType()   { return plateType; }
	public Date      getIssueDate()   { return issueDate; }
	public Date      getExpiryDate()  { return expiryDate; }
	public boolean   isDue()          { return due; }
	public double    getRenewalFee()  { return renewalFee; }
	public String    getBranch()      { return branch; }
	public String    getRegId()       { return regId; }
	
	public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
	public void setPlateType(String plateType)     { this.plateType = plateType; }
	public void setIssueDate(Date issueDate)       { this.issueDate = issueDate; }
	public void setExpiryDate(Date expiryDate)     { this.expiryDate = expiryDate; }
	public void setDue(boolean due)                { this.due = due; }
	public void setRenewalFee(double renewalFee)   { this.renewalFee = renewalFee; }
	public void setBranch(String branch)           { this.branch = branch; }
	public void setRegId(String regId)             { this.regId = regId; }
}
