package com.jetbluetest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jetbluetest.base.Base;


public class HomePage extends Base{
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[contains(text(),'T-shirts')])[2]")
	WebElement tshirtTab;
	
	@FindBy(xpath="//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement fadedShortSleeveTshirtLink;
	
	@FindBy(xpath="//p[@id='add_to_cart']//span[contains(text(),'Add to cart')]")
	WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='row']//h1")
	WebElement itemHeaderLabel;
	
	@FindBy(xpath="//div[@class='layer_cart_product_info']")
	WebElement selectedItemWindow2;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']")
	WebElement selectedItemWindowLabel;//layer_cart_product col-xs-12 col-md-6
	
	public HomePage(){		
		PageFactory.initElements(driver, this);
	}
	
	public void checkTshirtTab() throws InterruptedException{
		System.out.println("clicking Tshirt tab");
		Thread.sleep(5000);
		tshirtTab.click();
	}
	
	public void selectFadedshortSleeveTshirt(){
		boolean searchItem= fadedShortSleeveTshirtLink.isDisplayed();
		if(searchItem){
			fadedShortSleeveTshirtLink.click();
		}else{
			System.out.println("Faded Short Sleeve tshirt link not available");
		}
	}
	
	public void clickAddToCart(String item){
		
		if(itemHeaderLabel.getText().contains(item)){
			addToCartButton.click();
		}
		
	}
	
	public String  itemAddedSuccessfullyMessage() throws InterruptedException{
		
		Thread.sleep(3000);
		//System.out.println(selectedItemWindowLabel.getText());
		return selectedItemWindowLabel.getText();
		
	}
	
	
}
