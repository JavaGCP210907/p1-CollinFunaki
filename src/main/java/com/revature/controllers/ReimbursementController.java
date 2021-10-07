package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.dao.ReimbursementDao;
import com.revature.models.EmployeeLoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.StatusUpdate;
import com.revature.service.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
	ReimbursementDao rDao = new ReimbursementDao();
	
	Logger log = LogManager.getLogger(ReimbursementDao.class); //Logger object so that we can implement Logging

	public Handler getReimbursementsHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null){ //if a session exists
			
		//we create an Array with reimbursements data (using the service to talk to the dao)
		List<Reimbursement> allReimbursements = rs.getAllReimbursements();
		
		//instantiate a GSON object to make JSON <-> POJO conversions (Plain ol java object)
		Gson gson =new Gson();
		
		String JSONReimbursements = gson.toJson(allReimbursements); //convert our java object into a JSON String
		
		ctx.result(JSONReimbursements); //return our reimbursements
		
		ctx.status(200); //200 = OK (success)
		
		}else {
			ctx.status(403); //forbidden status code
		}
		
		
	};
	

	//handler for for when a manger updates a status
	public Handler updateStatus = (ctx) -> {
		
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson();
		
		StatusUpdate su = gson.fromJson(body, StatusUpdate.class); //turn that JSON String into a StatusUpdate object
		
		rs.updateReimbursement(su);
	
		ctx.status(200); //200 = OK (success)
		
		
	};

	//handler for when an employee wants to add a new reimbursement request
	public Handler addRequest = (ctx) -> {
			
			String body = ctx.body(); //turn the body (data) of the POST request into a Java String
			
			log.info(body);
			
			Gson gson = new Gson();
			
			Reimbursement r = gson.fromJson(body, Reimbursement.class); //turn that JSON String into a reimbursement object
			
			//set reimbursement id to one higher?
			
			log.info(r);
			
			rs.insertReimbursement(r);
		
			ctx.status(200); //200 = OK (success)
		
		
	};
	
	
	

}
