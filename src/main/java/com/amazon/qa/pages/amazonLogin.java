package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class amazonLogin extends TestBase{
	
	@FindBy(xpath="//*[contains(text(),\"Hello, Sign in\")]")
	WebElement signin;
	@FindBy(xpath="//input[@id=\"ap_email\"]")
	WebElement username;
	@FindBy(xpath="//input[@id=\"ap_password\"]")
	WebElement password;
	
	public amazonLogin() throws Exception {
		PageFactory.initElements(driver, this);
	}
	public String validateTitle() {
		return driver.getTitle();
	}
	public HomePage Login(String user,String pass) throws Exception {
		signin.click();
		username.sendKeys(user);
		username.submit();
		password.sendKeys(pass);
		password.submit();
		Thread.sleep(100);
		return new HomePage();
	}

}
