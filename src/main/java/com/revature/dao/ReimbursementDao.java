package com.revature.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.EmployeeLoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.StatusUpdate;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoInterface{
	
	Logger log = LogManager.getLogger(ReimbursementDao.class); //Logger object so that we can implement Logging
	
	//this method inserts a new reimbursement into the reimbursement table
	public void insertReimbursement(Reimbursement r) {

		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a connection with JDBC
		
		ses.save(r); 
		
		HibernateUtil.closeSession();
		
		log.info(r);
	}

	public List<Reimbursement> getAllReimbursements() {
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language. It references Java Classes not DB entities
		List<Reimbursement> rList = ses.createQuery("FROM Reimbursement").list();
		
		
		HibernateUtil.closeSession();
		
		return rList;
	}

	public void updateStatus(StatusUpdate su) {
		
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction(); //update and delete must happen within a transaction
		
		//updates and deletes take a little more work... You should put the query into a Query object
		//and then make sure to executeUpdate(), similar to in JDBC.
		
		Status newStatus = new Status();
		if(su.getStatus().equals("Pending")) {
			newStatus.setId(1);
			newStatus.setStatus("Pending");
		}else if(su.getStatus().equals("Denied")) {
			newStatus.setId(2);
			newStatus.setStatus("Denied");
		}else if(su.getStatus().equals("Approved")) {
			newStatus.setId(3);
			newStatus.setStatus("Approved");
		}
		
		log.info(newStatus);
		
		//Assign the Query syntax to a String
		String HQL = "UPDATE Reimbursement r SET r.status.id = " + newStatus.getId() + " WHERE id = " + su.getReimbId();
//		r.status.status = '" + su.getStatus() + "',
		
		//Instantiate a Query object with createQuery()
		Query q = ses.createQuery(HQL);
		
		//Send the update to the DB just like JDBC
		q.executeUpdate();
		
		//close transaction and session to prevent memory leak
		tran.commit();
		HibernateUtil.closeSession();
	}

	
}
