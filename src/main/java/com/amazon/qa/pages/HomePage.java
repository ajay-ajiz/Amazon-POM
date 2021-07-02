package com.amazon.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbar;
	@FindBy(xpath="//span[@class=\"a-size-medium a-color-base a-text-normal\"]")
	WebElement mobilelink;
	@FindBy(xpath="//span[@class=\"a-price-whole\"]")
	WebElement actualprice;
	
	@FindBy(xpath="//input[@id=\"buy-now-button\"]")
	WebElement buynow;
	
	public HomePage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	public String validatePrice() {
		return actualprice.getText();
	}
	public Product searchItem(String s) throws Exception {
		WebDriverWait wait1 = new WebDriverWait(driver, 100);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		
		
		searchbar.sendKeys(s);
		searchbar.submit();
		mobilelink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
//	    Thread.sleep(2000);
//	    Actions builder = new Actions(driver);
//	    
//	    builder.moveToElement(buynow).click().perform();
//	    buynow.click();
	    
		return new Product();
		
	}
	

}
