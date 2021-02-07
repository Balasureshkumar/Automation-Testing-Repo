package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Testbase.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name ="email")
	WebElement username;
	@FindBy(name ="password")
	WebElement password;
	@FindBy (xpath ="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement submit;
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
		    	
		    	
	}
}
