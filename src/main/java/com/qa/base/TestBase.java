package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.qa.utility.ScreenShotListener;
import com.qa.utility.Utils;

public class TestBase {
	
	
	   
		
		public static WebDriver driver;
		public static Properties prop;
		Logger log = Logger.getLogger(TestBase.class);

		//public  static EventFiringWebDriver e_driver;
		//public static WebEventListener eventListener;
		
		
		public TestBase(){
			//log.info(".............loading properties file...........");
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//log.info(".....Launching chrome browser and loading the URL.....");
		}
		
		
		public static void initialization(){
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "/home/day/Selenium_Resource/chromedriver");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "/home/day/Selenium_Resource");	
				driver = new FirefoxDriver(); 
			}
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));

		}
}



