package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

//import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

//import jdk.internal.org.jline.utils.Log;

public class UserDao implements UserDaoInterface{

	Logger log = LogManager.getLogger(ReimbursementDao.class); //Logger object so that we can implement Logging
	
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a connection with JDBC
		
		
		ses.save(user); 
		
		HibernateUtil.closeSession();
	}

	@Override
	public boolean verifyEmployeeLogin(String username, String password) {
		
		boolean login = false;
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a connection with JDBC
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);
		
		Root<User> root = q.from(User.class);
		q.select(root);
	
		Query<User> query = ses.createQuery(q);
		
		List<User> userList = query.getResultList();
		
		log.info(userList);
		
		for (User user : userList) {
			//if the user is an employee and their username and passowrd match a record, set login to true
			if(user.getRole().getId()==1 && user.getUsername().equals(username) && user.getPassword().equals(password)) {
				login = true;
				HibernateUtil.closeSession();
				log.info(login);
				return login;
			}
		}
		
		if(login==false) {
			HibernateUtil.closeSession();
			log.info(login);
		}
		
		return login;
	}

	@Override
	public boolean verifyManagerLogin(String username, String password) {
		
		boolean login = false;
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a connection with JDBC
		
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<User> q = cb.createQuery(User.class);
		
		Root<User> root = q.from(User.class);
		q.select(root);
	
		Query<User> query = ses.createQuery(q);
		
		List<User> userList = query.getResultList();
		
		log.info(userList);
		
		for (User user : userList) {
			//if the user is an employee and their username and passowrd match a record, set login to true
			if(user.getRole().getId()==2 && user.getUsername().equals(username) && user.getPassword().equals(password)) {
				login = true;
				HibernateUtil.closeSession();
				log.info(login);
				return login;
			}
		}
		
		if(login==false) {
			HibernateUtil.closeSession();
			log.info(login);
		}
		
		return login;
		
	}

	
}
