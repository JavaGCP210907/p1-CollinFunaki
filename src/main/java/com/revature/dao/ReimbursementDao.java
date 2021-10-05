package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoInterface{

	public void insertReimbursement(Reimbursement r) {

		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a connection with JDBC
		
		
		ses.save(r); 
		
		HibernateUtil.closeSession();
		
	}

	public List<Reimbursement> getAllReimbursements() {
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language. It references Java Classes not DB entities
		List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
		
		
		HibernateUtil.closeSession();
		
		return rList;
	}


}
