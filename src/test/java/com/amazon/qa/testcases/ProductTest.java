package com.amazon.qa.testcases;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.Product;
import com.amazon.qa.pages.amazonLogin;
import com.amazon.qa.util.AmazonExcelUtil;

public class ProductTest extends TestBase{

	amazonLogin alogin;
	HomePage homepage;
	Product product;
	public ProductTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		alogin=new amazonLogin();
		homepage=new HomePage();
		product=new Product();
		homepage=alogin.Login(prop.getProperty("username"), prop.getProperty("password"));
		Map<String,String>data=AmazonExcelUtil.getMap();
		log.debug(data.get("Searching Product"));
		product=homepage.searchItem(data.get("product name"));
	}
	@Test(priority=0)
	public void validateTitle() {
		log.debug("validate Title");
		String s=product.getTitle();
		Assert.assertNotEquals(s, prop.getProperty("producttitle"));
	}
	@Test(priority=1)
	public void proceedPayment() throws Exception {
		log.debug("proceed payment");
		Map<String,String>data=AmazonExcelUtil.getMap();
		String cardnum=data.get("card_number");
		product.payment(cardnum);
	}
	//@Test(priority=2)
	public void getMessage() throws Exception {
		log.debug("Getting Error message");
		Map<String,String>data=AmazonExcelUtil.getMap();
		String cardnum=data.get("card_number");
		product.payment(cardnum);
		String s=product.getmessage();
		Assert.assertEquals(s, "There was a problem.");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
