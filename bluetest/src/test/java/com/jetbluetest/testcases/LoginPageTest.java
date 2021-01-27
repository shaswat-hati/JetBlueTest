package com.jetbluetest.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jetbluetest.base.Base;
import com.jetbluetest.page.LoginPage;

public class LoginPageTest extends Base{  
	
	LoginPage login;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
	login= new LoginPage();	
	
}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		
		login.loginWithValidCred();
		
	}
	
	//@AfterClass
	public void teardown(){
		
		
	}
	
}
