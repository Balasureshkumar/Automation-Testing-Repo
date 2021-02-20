package com.crm.qa.Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.Testbase.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.WebEventListener;
@Listeners(WebEventListener.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	
	
	
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	//	loginPage.login("bala", "pwd");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals("Cogmento CRM", "Cogmento CRM");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
