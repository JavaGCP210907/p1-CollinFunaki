package com.revature;


import org.hibernate.HibernateException;
import org.hibernate.Session;

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
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		UserDao uDao = new UserDao();
		ReimbursementDao rDao = new ReimbursementDao();
		
		ReimbursementController rc = new ReimbursementController(); //to get access to the HTTP handlers in the controller layer
		
		ManagerLoginController mlc = new ManagerLoginController();
		EmployeeLoginController elc = new EmployeeLoginController();
		
		
//		try(Session ses = HibernateUtil.getSession()){
//			System.out.println("Hello you have a connection to your DB with Hibernate!");
//			HibernateUtil.closeSession();
//		} catch (HibernateException e) {
//			System.out.println("DB connection failed!!");
//		}
		
		
		//create data for the database ----------------------vvvvvv
		
		//create user role table/data/objects/data
		Role employee = new Role("Employee");
		Role fm = new Role("Finance Manager");

		
		//create statuses table/data/objects/data
		Status pending = new Status(1, "Pending");
		Status denied = new Status(2, "Denied");
		Status approved = new Status(3, "Approved");
		
		///create status types table/data/objects/data
		Type L = new Type("Lodging");
		Type T = new Type("Travel");
		Type F = new Type("Food");
		Type O = new Type("Other");

		//create a user table/data/objects/data
		User e1 = new User("employee", "password", "John", "Doe", "jdoe@email.com", employee);
		User fm1 = new User("manager", "password", "Obama", "???", "obama44@email.com", fm);
		User e2 = new User("jdoe123", "password", "John", "Doe", "jdoe@email.com", employee);
		User fm2 = new User("pres44", "password", "Obama", "???", "obama44@email.com", fm);
		User e3 = new User("bc1", "password", "Robert", "Saget", "bsaget@email.com", employee);
		User fm3 = new User("mrapple", "password", "Steven", "Jobs", "appleguy@email.com", fm);
		
		
		//create a reimbursement table/data/objects/data
		//Reimbursemnt(amount, date submitted, date resolves, description, recipt pic, author, resolver, status, type)
		Reimbursement r1 = new Reimbursement(20, null, null, "did something", null,
				e1, fm1, approved, L);
		Reimbursement r2 = new Reimbursement(100, null, null, "got mcdonalds", null,
				e2, fm1, pending, F);
		Reimbursement r3 = new Reimbursement(200, null, null, "got a hotel", null,
				e2, fm2, approved, T);
		Reimbursement r4 = new Reimbursement(50, null, null, "got materials", null,
				e3, fm3, denied, O);
		
		
		//insert data into our database tables
		rDao.insertReimbursement(r1);
		rDao.insertReimbursement(r2);
		rDao.insertReimbursement(r3);
		rDao.insertReimbursement(r4);
		
		
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
