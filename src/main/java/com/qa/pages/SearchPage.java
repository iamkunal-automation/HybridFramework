package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SearchPage extends TestBase {
	
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchButton;
	@FindBy(xpath="//div[@class='swal-button-container']//button[text()='OK']")
	WebElement OKButton;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement SearchBox;
	@FindBy(xpath="//h3[text()='No results found!']")
	WebElement noResultFoundMessage;
	@FindBy(xpath="//h2[text()=' gfhf ']")
	WebElement searchResult;
	
	
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifySearchWithEmptyKeyword() {
		WebElement searchButton =driver.findElement(By.xpath("//button[text()=' Search ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchButton);
	   	if(OKButton.isEnabled()) {
	   		return true;
	   	} 
	   	else {
	   		return false;
	   	}
	}
	
	public boolean searchButtonClickability() {
		if(searchButton.isEnabled()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String verifyNoResultFoundSearch() {
		SearchBox.sendKeys("gfgf");
		WebElement searchButton =driver.findElement(By.xpath("//button[text()=' Search ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchButton);
	   	 String message=noResultFoundMessage.getText();
	   	 return message;		
	}
	
	public boolean verifySearchResult() {
		SearchBox.sendKeys("gfhf");
		WebElement searchButton =driver.findElement(By.xpath("//button[text()=' Search ']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchButton);
	   	 if(searchResult.isDisplayed()) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false;
	   	 }
		

	}
	
	public String verifyPlaceHolder() {
		String placeholder=SearchBox.getAttribute("placeholder");
		return placeholder;
	}
	
	

}
