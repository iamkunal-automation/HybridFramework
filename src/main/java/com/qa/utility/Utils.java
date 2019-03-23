package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class Utils extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	
	public void myWait(long time) throws InterruptedException
	{
		Thread.sleep(time);
	}
	
	public void selectValueFromDropdown(WebElement categories,int index)
	{
		Select select=new Select(categories);
		select.selectByIndex(index);
		
	}
	
	
	public void takeScreenShot() throws IOException
	{
		 File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshotFile, new File("/home/day/eclipse-workspace/WeeklyPaper/Screenshots/"));
	}
	
	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
	}
	
}
