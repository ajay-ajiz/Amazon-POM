package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class Product extends TestBase {
	@FindBy(xpath="//input[@id=\"buy-now-button\"]")
	WebElement buynow;
	@FindBy(xpath="//*[contains(text(),\" Deliver to this address\")]")
	WebElement deliveraddress;
	@FindBy(xpath="//input[@name=\"ppw-instrumentRowSelection\" and @value=\"SelectableAddCreditCard\"]")
	WebElement cardoption;
	@FindBy(xpath="//a[@id=\"pp-RrQafY-80\"]")
	WebElement addcardlink;
	@FindBy(xpath="//input[@id=\"pp-dstmAZ-14\"]")
	WebElement cardnumber;
	@FindBy(xpath="//input[@name=\"ppw-widgetEvent:AddCreditCardEvent\"]")
	WebElement addcardbutton;
	@FindBy(xpath="//h4[contains(text(),\"There was a problem.\") and @class=\"a-alert-heading\"][1]")
	WebElement errormsg;
	public Product() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public void payment(String s) throws Exception {
		
		Thread.sleep(4000);
//		WebDriverWait wait1 = new WebDriverWait(driver, 30);
//		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"submit.buy-now\" and @title=\"Select exchange item details\"]")));
		buynow.click();
		Thread.sleep(4000);
		deliveraddress.click();
		Thread.sleep(4000);
		cardoption.click();
//		Thread.sleep(400);
//		addcardlink.click();
		
		
	}
	public String getmessage() throws Exception {
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		cardnumber.sendKeys("1234");
		cardnumber.submit();
		return errormsg.getText();
	}
	public String getTitle() {
		return driver.getTitle();
	}

}
