package com.amazon.qa.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.Product;
import com.amazon.qa.pages.amazonLogin;
import com.amazon.qa.util.AmazonExcelUtil;

public class HomePageTest extends TestBase{
	amazonLogin alogin;
	HomePage homepage;
	Product product;
	
	
	public HomePageTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		alogin=new amazonLogin();
		homepage=new HomePage();
		product=new Product();
		homepage=alogin.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=0)
	public void searchItem() throws Exception {
		log.debug("Search Product");
		Map<String,String>data=AmazonExcelUtil.getMap();
		log.debug(data.get("Searching Product"));
		product=homepage.searchItem(data.get("product name"));
		
	}
	@Test(priority=1)
	public void validatePrice() throws Exception {
		log.debug("Validate Price");
		String s=homepage.validatePrice();
		//Map<String,String>data=AmazonExcelUtil.getMap();
		
		Assert.assertNotEquals(s, "2000");
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
