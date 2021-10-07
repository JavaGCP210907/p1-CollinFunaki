package com.revature.service;

import java.util.List;

import org.hibernate.Session;

import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class EmployeeLoginService {
	
	//hardcoding username/password --I dont want to create a whole users table/DAO
	
	//typically youll want to validate user/pass aginst some user/pass in your database
		//so in your P1 key youd be sending the data from the LoginDTO into the dao
	
	public boolean login(String username, String password) {
		
		//if login is correct, change this so it isnt hardcoded
//		if(username.equals("employee") && password.equals("password")) {
//			
//			return true;
//			
//		} 
//		
//		
//		return false;
		
		
//		Session ses = HibernateUtil.getSession();
//		
//		HibernateUtil.closeSession();
		UserDao uDao = new UserDao();
		
		
		//not hardcoded version
		if(uDao.verifyEmployeeLogin(username, password)) {
			return true;
			
		} 
		
		
		return false;
		
		
	}

}
