package carregistry.model;

public class User {
	private String id, password, role;
	
	public User() {
		this.id       = "";
		this.password = "";
		this.role     = "";
	}
	
	public User(String id, String password) {
		this.id       = id;
		this.password = password;
	}
	
	public User(String id, String password, String role) {
		this.id       = id;
		this.password = password;
		this.role     = role;
	}
	
	public String getId()       { return id; }
	public String getPassword() { return password; }
	public String getRole()     { return role; }

	public void setId(String id)             { this.id = id; }
	public void setPassword(String password) { this.password = password; }
	public void setRole(String role)         { this.role = role; }
}
