package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDaoInterface {

	public void insertReimbursement(Reimbursement r);
	
	public List<Reimbursement> getAllReimbursements();
	
}
