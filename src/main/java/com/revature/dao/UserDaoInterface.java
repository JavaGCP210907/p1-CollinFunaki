package com.revature.dao;

import com.revature.models.User;

public interface UserDaoInterface {

	public void insertUser(User user);
	
	public boolean verifyEmployeeLogin(String username, String password);
	
	public boolean verifyManagerLogin(String username, String password);
	
}
