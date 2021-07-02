package com.amazon.qa.base;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.qa.util.TestUtilities;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	public TestBase() throws Exception {
		  File file=new File("C:\\Users\\INFOSYS\\eclipse-workspace\\workspace\\Amazon\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
		  FileInputStream fileInput = null;
		  
		  fileInput = new FileInputStream(file);
		  prop=new Properties();
		  prop.load(fileInput);	
	}
	public static void initialization() {
		//String s=prop.getProperty("flipkart_url");
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\INFOSYS\\Desktop\\ajay\\chrome_driver\\chromedriver.exe");
		  
		  driver= new ChromeDriver();
		  log = Logger.getLogger("Amazon logger");
		  log.debug("Chrome driver Initialisation");
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(TestUtilities.pageLoadTimeOut, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(TestUtilities.impiciteWait, TimeUnit.SECONDS);
		  driver.get("https://www.amazon.in/");
		 
		  
	}
	
	
	
	
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	

	
}

