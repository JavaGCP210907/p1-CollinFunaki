package com.revature.dao;

import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserDaoInterface{

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a connection with JDBC
		
		
		ses.save(user); 
		
		HibernateUtil.closeSession();
	}

}
