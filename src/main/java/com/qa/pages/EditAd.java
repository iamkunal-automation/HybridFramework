package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class EditAd extends TestBase {
	
	LoginPage login=new LoginPage();
	Utils util=new Utils();
	
	
	// Object Repository:OR
	
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	@FindBy(xpath="//div[@class='myaccount']//ul//li[2]")
	WebElement savedAdLink;
	@FindBy(xpath="//table[@class='table']//tr//td//a[1]")
	WebElement editButton;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement updatetinycrossbutton;
	
	
	
	public EditAd() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean editButtonClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		savedAdLink.click();
		Thread.sleep(3000);
		if(editButton.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean editAd() throws InterruptedException {
		login.loginfunctionality();
		userimage.click();
		Thread.sleep(3000);
		savedAdLink.click();
		editButton.click();
		description.clear();
		description.sendKeys("My second Description");
		util.scrollPage();
		WebElement Createad=driver.findElement(By.xpath("//input[@class='btn btn-primary createbtn']"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad);
		 
		 if(updatetinycrossbutton.isEnabled()) {
			 return true;
		 }
		 else {
			 return false;
		 }
		
	}
	
	public String UpdateAdPageTitle() throws InterruptedException {
		login.loginfunctionality();
		userimage.click();
		Thread.sleep(3000);
		savedAdLink.click();
		editButton.click();
		String title=driver.getTitle();
		return title;
		
	}

}
