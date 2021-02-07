package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Testbase.TestBase;

public class DealsPage extends TestBase{
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement title;
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[6]/div[1]/div/div/input")
	WebElement amount;
	@FindBy(xpath ="//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[2]/div/div/input")
	WebElement probability;
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[6]/div[2]/div/div/input")
	WebElement commision;
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	
	WebElement savebutton;
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	public void user_enters_contacts_details() {
		
		title.sendKeys("Test101");
		amount.sendKeys("5000");
		probability.sendKeys("50");
		commision.sendKeys("15");
		savebutton.click();
	}
	
	

}
