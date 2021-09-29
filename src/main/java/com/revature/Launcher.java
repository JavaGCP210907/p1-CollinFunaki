package com.revature;

import java.sql.Blob;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class Launcher {

	public static void main(String[] args) {
		
		UserDao uDao = new UserDao();
		ReimbursementDao rDao = new ReimbursementDao();
		
		try(Session ses = HibernateUtil.getSession()){
			System.out.println("Hello you have a connection to your DB with Hibernate!");
			HibernateUtil.closeSession();
		} catch (HibernateException e) {
			System.out.println("DB connection failed!!");
		}
		
		//create user roles
		Role r1 = new Role("customer");
		
		//create statuses
		Status s1 = new Status("complete");
		
		///create status types
		Type t1 = new Type("1");

		//create a user
		User u1 = new User("user1", "password", "John", "Doe", "jdoe@email.com", r1);
		
		//create a reimbursement
		Reimbursement reimb1 = new Reimbursement(20, null, null, "did something", null,
				u1, u1, s1, t1);
		
		System.out.println(reimb1);
		
		rDao.insertReimbursement(reimb1);
	}

}
