package com.revature.models;

public class EmployeeLoginDTO {
	
	//our LoginDTO models only the username/password of our users
	private String username;
	private String password;

	public EmployeeLoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeLoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeLoginDTO [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
