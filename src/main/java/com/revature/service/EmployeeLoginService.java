package com.revature.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDao;


public class EmployeeLoginService {
	
	Logger log = LogManager.getLogger(); //Logger object so that we can implement Logging
	
	//validate user/pass aginst some user/pass in your database
	//so in your P1 key youd be sending the data from the LoginDTO into the dao
	
	public boolean login(String username, String password) {
		
		UserDao uDao = new UserDao();
		
		//if the login info matches an employee in the database
		if(uDao.verifyEmployeeLogin(username, password)) {
			log.info("successful employee login");
			return true;
			
		} 
		log.info("unsuccessful employee login");
		return false;
		
	}

}
