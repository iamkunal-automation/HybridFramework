package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class PastAdPage  extends TestBase{
	
	//Object Repository :OR
	
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	@FindBy(xpath="//div[@class='myaccount']//ul//li[3]")
	WebElement pastAdLink;
	
	@FindBy(xpath="//div[@class='col-xs-12']//p")
	WebElement noPastAdMessage;
	
	
	
	public PastAdPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean pastAdButtonClickability() {
		userimage.click();
		if(pastAdLink.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String pastAdPageTitle() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		pastAdLink.click();
		String title=driver.getTitle();
		return title;
	}
	
	public boolean noPastAdMessage() throws InterruptedException {
		userimage.click();
		Thread.sleep(3000);
		pastAdLink.click();
		String message=noPastAdMessage.getText();
		if(message.contains("You Don't Have")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

}
