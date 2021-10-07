package com.revature.service;

import com.revature.dao.UserDao;

public class ManagerLoginService {

	//hardcoding username/password --I dont want to create a whole users table/DAO
	
	//typically youll want to validate user/pass aginst some user/pass in your database
		//so in your P1 key youd be sending the data from the LoginDRO into the dao
	
	public boolean login(String username, String password) {
		
		//if login is correct, change this so it isnt hardcoded
//		if(username.equals("manager") && password.equals("password")) {
//			
//			return true;
//			
//		}
//		
//		return false;
		
		UserDao uDao = new UserDao();
		
		//not hardcoded
		if(uDao.verifyManagerLogin(username, password)) {
			
			return true;
			
		} 
		
		
		return false;
		
		
	}
	
	
}
