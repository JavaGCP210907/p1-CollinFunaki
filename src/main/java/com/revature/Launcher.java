package com.revature;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.LoginController;
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
		LoginController lc = new LoginController();
		
//		try(Session ses = HibernateUtil.getSession()){
//			System.out.println("Hello you have a connection to your DB with Hibernate!");
//			HibernateUtil.closeSession();
//		} catch (HibernateException e) {
//			System.out.println("DB connection failed!!");
//		}
		
		//create data for the database
		//create user role table/data/objects/data
		
		Role r1 = new Role("customer");
		
		//create statuses table/data/objects/data
		Status s1 = new Status("complete");
		
		///create status types table/data/objects/data
		Type t1 = new Type("1");

		//create a user table/data/objects/data
		User u1 = new User("user1", "password", "John", "Doe", "jdoe@email.com", r1);
		
		//create a reimbursement table/data/objects/data
		Reimbursement reimb1 = new Reimbursement(20, null, null, "did something", null,
				u1, u1, s1, t1);
		
		System.out.println(reimb1);
		
		//insert data into our database tables
		rDao.insertReimbursement(reimb1);
		
		
		///////////////////////////////////////
		
		//Set up connection to Postman server using Javalin
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create().start(3000);
		
		//HTTP Handlers below...
		
		//any GET requests to this default endpoint (/) will return this text
		app.get("/", ctx -> ctx.result("Hello Javalin! My Application recieved a GET request! how cool ;)"));
		//any POST requests sent to this default endpoint (/) will return this text
		app.post("/", ctx -> ctx.result("Hello Javalin! My Application recieved a POST request! how nice ;)"));
		
		
		//GET all reimbursements
		//GET reimbursements => return all reimbursements
		app.get("/reimbursements", rc.getReimbursementsHandler);
		
		//imagine we have users
		//send a POST request to validate user login credentials
		app.post("/login", lc.loginHandler);
		
	}
	

}
