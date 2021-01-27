package com.jetbluetest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jetbluetest.base.Base;
import com.jetbluetest.page.HomePage;
import com.jetbluetest.page.LoginPage;

public class HomePageTest extends Base{  
	
	LoginPage login;
	HomePage home;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
	login= new LoginPage();	
	home= new HomePage();	
	
}
	
	@Test(priority=0)
	public void verifyItemAddToCart() throws InterruptedException {
		String item="Faded Short Sleeve T-shirts";
		login.loginWithValidCred();
		home.checkTshirtTab();
		home.selectFadedshortSleeveTshirt();		
		home.clickAddToCart(item);
		
	}
	
	@Test(priority=1)
	public void verifyProductAddedSuccessfully() throws InterruptedException {
		
		String successMessage="Product successfully added to your shopping cart";	
		String itemName="Faded Short Sleeve T-shirts";
		String itemColor="Orange, S";
		String itemQnty="1";
		String itemPrice="$16.51";
		//home.itemAddedSuccessfullyMessage();
		Assert.assertTrue(home.itemAddedSuccessfullyMessage().contains(successMessage));
		Assert.assertTrue(home.itemAddedSuccessfullyMessage().contains(itemName));
		Assert.assertTrue(home.itemAddedSuccessfullyMessage().contains(itemColor));
		Assert.assertTrue(home.itemAddedSuccessfullyMessage().contains(itemQnty));
		Assert.assertTrue(home.itemAddedSuccessfullyMessage().contains(itemPrice));
	}
	
	
}
