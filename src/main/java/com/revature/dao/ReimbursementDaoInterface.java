package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.StatusUpdate;

public interface ReimbursementDaoInterface {

	public void insertReimbursement(Reimbursement r);
	
	public List<Reimbursement> getAllReimbursements();
	
	public void updateStatus(StatusUpdate su);
	
	
	
}
