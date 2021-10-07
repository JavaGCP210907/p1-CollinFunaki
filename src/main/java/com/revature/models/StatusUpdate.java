package com.revature.models;

//this class is used to update the status of reimbursemnt
public class StatusUpdate {
	
	private int reimbId;
	private String status;
	
	public StatusUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatusUpdate(int reimbId, String status) {
		super();
		this.reimbId = reimbId;
		this.status = status;
	}
	@Override
	public String toString() {
		return "statusUpdate [reimbId=" + reimbId + ", status=" + status + "]";
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
