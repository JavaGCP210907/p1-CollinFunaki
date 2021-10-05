package com.revature.service;

public class LoginService {

	//hardcoding username/password --I dont want to create a whole users table/DAO
	
	//typically youll want to validate user/pass aginst some user/pass in your database
		//so in your P1 key youd be sending the data from the LoginDRO into the dao
	
	public boolean login(String username, String password) {
		
		//if login is correct, change this so it isnt hardcoded
		if(username.equals("collin") && password.equals("password")) {
			
			return true;
			
		}
		
		return false;
	}
	
	
}
