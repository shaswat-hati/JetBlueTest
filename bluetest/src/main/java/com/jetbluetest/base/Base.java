package com.jetbluetest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public Base(){
		File conf = new File(System.getProperty("user.dir")+
				"\\src\\main\\java\\com\\jetbluetest\\config\\config.properties");
		try{
		FileInputStream fis = new FileInputStream(conf);
		
		prop = new Properties();
		prop.load(fis);
		}
		
		catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
		}
	}
	
	@Parameters("browser")
	@BeforeClass
	public  void setup(String browser){
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Drivers/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	//@AfterClass
	public void teardown(){
		driver.quit();
	}
	
	
	
	
	
	
	

}
