package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver; //Null pointer exception
	
	By email = By.id("input-email");
	By pass = By.id("input-password");
	By loginBtn = By.xpath("//input[@value='Login']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getTitleofLoginPage() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		
		return driver.getCurrentUrl();
	}
	
	
	public void doLogin(String uN, String pwd) {
		
		WebElement ele = driver.findElement(email);
		ele.clear();
		ele.sendKeys(uN);
		driver.findElement(pass).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}
	

}
