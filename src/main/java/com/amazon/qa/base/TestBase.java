package com.amazon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


public class TestBase {
	//public static WebDriver driver;
	public static Properties prop;
	 WebDriver driver;
	
	public TestBase()  {
		  File file=new File("C:\\Users\\INFOSYS\\eclipse-workspace\\workspace\\project1\\src\\main\\java\\com\\flipkart\\qa\\config\\conf.properties");
		  FileInputStream fileInput = null;
		  try{
			  fileInput = new FileInputStream(file);
		  }
		  catch (FileNotFoundException e){
			  e.printStackTrace();
		  }
		  
		  prop=new Properties();
		  try {
			  prop.load(fileInput);
		  }
		  catch (IOException e){
			  e.printStackTrace();
		  }
		  

		
	}
	public static void initialization() {
		//String s=prop.getProperty("flipkart_url");
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\INFOSYS\\Desktop\\ajay\\chrome_driver\\chromedriver.exe");
		 
		  
	}
	
	
	
	
	
//	public WebDriver getDriver() {
//		// TODO Auto-generated method stub
//		return driver;
//	}
//	
	
}

