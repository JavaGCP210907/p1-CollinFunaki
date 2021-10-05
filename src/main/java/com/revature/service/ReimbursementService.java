package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.models.Reimbursement;

//the service layer sits between the controllers and the daos
public class ReimbursementService {
	
	//instantiate an AvengersDao to use its methods
	ReimbursementDao rDao = new ReimbursementDao();
	
	
	//create a method that gets the DAO data and sends it up to the controller
	//this method will get called by the controller layer
	public List<Reimbursement> getAllReimbursements(){
	
		return rDao.getAllReimbursements();
		
	}
	
	
	//all were doing is calling the dao method in order to get a List of all the avnegers to send to the controller
	

	

}
