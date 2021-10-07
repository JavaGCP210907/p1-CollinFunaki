package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestServices {
	
	public static EmployeeLoginService els; 
	public static ManagerLoginService mls; 
	public static ReimbursementService rs; 
	
	@BeforeAll
	public static void createServiceObject() {
		els = new EmployeeLoginService();
		mls = new ManagerLoginService();
		rs = new ReimbursementService();
		System.out.println("Before all");
	}
	
	@AfterAll
	public static void clearServiceObject() {
		els = null;
		mls = null;
		rs = null;
		System.out.println("After all");
	}
	
	@Test
	public static void testELogin() {
		System.out.println("Testing Successsful Employee Login");
		System.out.println();
		assertTrue(els.login("employee", "password"));
	}
	
	@Test 
	public static void testMLogin() {
		System.out.println("Testing Successful Manager Login");
		System.out.println();
		assertTrue(mls.login("manager", "password"));
	}
	
	@Test
	public static void testEmployeeTryingToMLogin() {
		System.out.println("Testing Employee trying to login as a manager");
		System.out.println();
		assertFalse(mls.login("employee", "password"));
	}
	
	@Test
	public static void testManagerTryingToELogin() {
		System.out.println("Testing Manager trying to login as an employee");
		System.out.println();
		assertFalse(els.login("manager", "password"));
	}
	
	@Test
	
	
	
	
}