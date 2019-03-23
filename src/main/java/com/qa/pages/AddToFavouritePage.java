package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AddToFavouritePage extends TestBase {
	
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	@FindBy(xpath="//div[@class='myaccount']//ul//li[4]")
	WebElement favouriteAdLink;
	@FindBy(xpath="//a[text()=' Art / Books / Collectables / Music ']")
	WebElement categoryName;
	@FindBy(xpath="//i[@class='fa fa-heart']")
	WebElement hearticon;
	@FindBy(xpath="//a[@href='http://beta.weeklypaper.org/US/categories/515/art--books--collectables--music']")
	WebElement productNearhearticon;
	@FindBy(xpath="//td[@data-th='Picture']")
	WebElement productOnFavouriteAdPage;
	@FindBy(xpath="//div[@class='product_name']")
	WebElement productLabel;
	@FindBy(xpath="//div[@class='logo']")
	WebElement logo;
	@FindBy(xpath="//i[@class='fa fa-times']")
	WebElement deleteIcon;
	@FindBy(xpath="//button[text()='Yes']")
	WebElement YESButton;
	@FindBy(xpath="//h3//p")
	WebElement message;
	
	
	
	
	public AddToFavouritePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean favouriteAdLinkClickability() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		if(favouriteAdLink.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String favouriteAdPageVerification() throws InterruptedException {
		userimage.click();
		Thread.sleep(5000);
		favouriteAdLink.click();
		String title=driver.getTitle();
		return title;
		
	}
	
	public boolean favouriteIconEnableVerification() {
		categoryName.click();
		if(hearticon.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyFavouriteAd() throws InterruptedException {
		categoryName.click();
		hearticon.click();
		Thread.sleep(6000);
		userimage.click();
		favouriteAdLink.click();
		if(productOnFavouriteAdPage.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
		
			}
	public boolean verifyDeleteAd() throws InterruptedException {
		categoryName.click();
		hearticon.click();
		Thread.sleep(6000);
		userimage.click();
		favouriteAdLink.click();
		deleteIcon.click();
		WebElement YESButton=driver.findElement(By.xpath("//button[text()='Yes']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", YESButton);
	   	 String noAdsMessage=message.getText();
	   	 if(noAdsMessage.contains("Favourite Ads Yet")) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
	   		 
	   		 
		
		
		
			}
	
	

}
