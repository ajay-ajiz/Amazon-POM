package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.amazonLogin;

public class AmazonLoginTest extends TestBase{
	amazonLogin alogin;
	HomePage homepage;
	public AmazonLoginTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();	
		alogin=new amazonLogin();
		homepage=new HomePage();
	}

	@Test(priority=0)
	public void ValidateTitle() {

		String s=alogin.validateTitle();
		Assert.assertEquals(s, "");
	}
	@Test(priority=1)
	public void Login() throws Exception {
		String user=prop.getProperty("username");
		String pass=prop.getProperty("password");
		homepage=alogin.Login(user,pass);
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
}
