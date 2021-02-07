package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Testbase.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[5]")
	WebElement dealsLink;
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a[3]/button")
	WebElement deals;


	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
/*	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}*/
	
	public DealsPage clickOnDealsLink() throws InterruptedException{
		
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).click().build().perform();
		Thread.sleep(3000);
		deals.click();
		return new DealsPage();
	}
	
	/*public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}*/
	

}
