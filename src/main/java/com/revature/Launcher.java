package com.revature;


import com.revature.controllers.EmployeeLoginController;
import com.revature.controllers.ManagerLoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDao;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//to get acces to the DAO methods
		UserDao uDao = new UserDao();
		ReimbursementDao rDao = new ReimbursementDao();
		
		//to get access to the HTTP handlers in the controller layer
		ReimbursementController rc = new ReimbursementController();
		
		//to get access to the controller methods
		ManagerLoginController mlc = new ManagerLoginController();
		EmployeeLoginController elc = new EmployeeLoginController();
		
		
		//create data for the database ----------------------vvvvvv
		
		//create user role table/data/objects/data
		Role employee = new Role("Employee");
		Role fm = new Role("Finance Manager");
		
		//create statuses table/data/objects/data
		Status pending = new Status(1, "pending");
		Status denied = new Status(2, "denied");
		Status approved = new Status(3, "approved");
		
		///create status types table/data/objects/data
		Type L = new Type("Lodging");
		Type T = new Type("Travel");
		Type F = new Type("Food");
		Type O = new Type("Other");

		//create a user table/data/objects/data
		User e1 = new User("cfunaki", "password", "Collin", "Funaki", "collinf@vt.edu", employee);
		User fm1 = new User("manager", "password", "Barack", "Obama", "obama44@email.com", fm);
		User fm2 = new User("ben", "password", "Ben", "Petruzzielo", "themrfunsocks@gmail.com", fm);
		User e2 = new User("pres44", "password", "Obama", "???", "obama44@email.com", employee);
		User e3 = new User("employee", "password", "John", "Doe", "jdoe1@.gmail.com", employee);
		User fm3 = new User("mrapple", "password", "Steven", "Jobs", "appleguy@email.com", fm);
		
		
		//create a reimbursement table/data/objects/data
		//Reimbursemnt(amount, date submitted, date resolves, description, recipt pic, author, resolver, status, type)
		Reimbursement r1 = new Reimbursement(20, "2021-07-02", "2021-08-13", "did something", null,
				e1, fm1, approved, O);
		Reimbursement r2 = new Reimbursement(100, "2021-08-30", "unresolved", "bought mcdonalds", null,
				e2, fm1, pending, F);
		Reimbursement r3 = new Reimbursement(200, "2021-09-01", "2021-09-21", "got a hotel", null,
				e2, fm2, approved, L);
		Reimbursement r4 = new Reimbursement(50, "2021-09-04", "2021-09-23", "got materials", null,
				e3, fm3, denied, O);
		
		Reimbursement r5 = new Reimbursement(50, "2021-09-29", "2021-09-30", "called a taxi", null,
				e1, fm2, approved, T);
		Reimbursement r6 = new Reimbursement(800, "2021-09-30", "2021-10-01", "bought a new laptp", null,
				e2, fm2, denied, O);
		Reimbursement r7 = new Reimbursement(50, "2021-10-03", "unresolved", "plane tickets", null,
				e3, fm3, pending, T);
		Reimbursement r8 = new Reimbursement(50, "2021-10-07", "unresolved", "got a hotel", null,
				e1, fm2, pending, L);
		
		
		//insert data into our database tables
		rDao.insertReimbursement(r1);
		rDao.insertReimbursement(r2);
		rDao.insertReimbursement(r3);
		rDao.insertReimbursement(r4);
		rDao.insertReimbursement(r5);
		rDao.insertReimbursement(r6);
		rDao.insertReimbursement(r7);
		rDao.insertReimbursement(r8);
		
		
		///////////////////////////////////////
		
		//Set up connection to Postman server using Javalin
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server 
				}
				).start(3000);
		
		
		//HTTP Handlers below...
		
		//Employee actions
		//send a POST request to validate employee login credentials
		app.post("/elogin", elc.eloginHandler);
		//add (POST) a new reimbursement request
		app.post("/newReimb", rc.addRequest);
		
		
		//-----------------------------------
		
		
		//Manager actions 
		//send a POST request to validate manager login credentials
		app.post("/mlogin", mlc.mloginHandler);
		//GET all reimbursements => return all reimbursements
		app.get("/reimbursements", rc.getReimbursementsHandler);
		//update (PATCH) the status of a reimbursment
		app.patch("/reimbursements", rc.updateStatus);
		
	}
	

}
