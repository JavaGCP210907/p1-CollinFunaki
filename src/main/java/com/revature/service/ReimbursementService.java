package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.StatusUpdate;

//service layer sits between the controllers and the daos
public class ReimbursementService {
	
	//instantiate an ReimbursementDao to use its methods
	ReimbursementDao rDao = new ReimbursementDao();
	
	
	//create a method that gets the DAO data and sends it up to the controller
	//this method will get called by the controller layer
	public List<Reimbursement> getAllReimbursements(){
	
		return rDao.getAllReimbursements();
		
	}


	//call the insertReimbursement method from the reimbursement dao to actually make the insert
	public void insertReimbursement(Reimbursement r) {
		
		rDao.insertReimbursement(r);
		
	}

	//call the updateReimbursement method from the reimbursement dao to actually make the update
	public void updateReimbursement(StatusUpdate su) {
		
		rDao.updateStatus(su);
		
	}


	
	
	//all were doing is calling the dao method in order to get a List of all the avnegers to send to the controller
	

	

}
