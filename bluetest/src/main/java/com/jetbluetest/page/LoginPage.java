package com.jetbluetest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jetbluetest.base.Base;


public class LoginPage extends Base{	

	@FindBy(xpath="//a[@Title='Log in to your customer account']")
	WebElement signInLink;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailInput;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordInput;//commit
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement enterButton;
	
	public LoginPage(){			
		PageFactory.initElements(driver, this);
	}
	
	
	
	public HomePage loginWithValidCred() throws InterruptedException{
		signInLink.click();
		emailInput.sendKeys(prop.getProperty("emailid"));
		passwordInput.sendKeys(prop.getProperty("password"));
		//Thread.sleep(2000);
		enterButton.click();
		return new HomePage();
	}
	
	
}
