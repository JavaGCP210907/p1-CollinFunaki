package com.revature.service;

import com.revature.dao.UserDao;


public class EmployeeLoginService {
	
	//hardcoding username/password --I dont want to create a whole users table/DAO
	
	//typically youll want to validate user/pass aginst some user/pass in your database
		//so in your P1 key youd be sending the data from the LoginDTO into the dao
	
	public boolean login(String username, String password) {
		
		UserDao uDao = new UserDao();
		
		//if the login info matches an employee in the database
		if(uDao.verifyEmployeeLogin(username, password)) {
			return true;
			
		} 
		
		return false;
		
	}

}
