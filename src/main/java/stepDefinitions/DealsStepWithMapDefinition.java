package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

//data table with maps : for parameterization of test cases

public class DealsStepWithMapDefinition {

	WebDriver driver;
	
	@Given("^user is present on Login Page$")
	 public void user_present_on_login_page(){
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala\\Downloads\\chromedriver_win32_6\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https:www.freecrm.com");
		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/a")).click();

	 }
	
	
	 @When("^title of login page will be is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	// Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^user enters the credentials \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.name("email")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 }
	
	 @Then("^user needs to clicks on login button$")
	 public void userneeds_clicks_on_login_button() throws InterruptedException {
		 WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginBtn);
			Thread.sleep(10000);
	 }
	
	
	 @Then("^user will navigate to home page$")
	 public void user_will_navigate_to_home_page(){
	 String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("Cogmento CRM", title);
	 }
	 @Then("^need to quit$")
		public void close_cuurent_the_browser() {
			driver.quit();
		}

	@Given("^Already on Login Page$")
	public void user_already__navigated_to_login_page() throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala\\Downloads\\chromedriver_win32_6\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/a")).click();
		Thread.sleep(10000);
	}

	@When("^login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
	//	Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {

			driver.findElement(By.name("email")).sendKeys(data.get("username"));
			driver.findElement(By.name("password")).sendKeys(data.get("password"));

		}

	}

	@Then("^clicks on login button$")
	public void user_clicks_on_login_button() throws InterruptedException {
		//*[@id="ui"]/div/div/form/div/div[3]
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(10000);
	}

	@Then("^is on home page$")
	public void user_is_on_hopme_page() throws InterruptedException {
		Thread.sleep(10000);
		String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("Cogmento CRM", title);
	}

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deals_page() throws InterruptedException {
		//driver.switchTo().frame("mainpanel");
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		String res=driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[5]")).getText();
		System.out.println(res);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[5]"))).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a[3]/button")).click();

	}

	@Then("^user enters deal details$")
	public void user_enters_contacts_details(DataTable dealData) throws InterruptedException {

		for (Map<String, String> data : dealData.asMaps(String.class, String.class)) {
			//*[@id="main-content"]/div/div[2]/form/div[1]/div[1]/div/div/input

			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")).sendKeys(data.get("title"));
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[6]/div[1]/div/div/input")).sendKeys(data.get("amount"));
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[2]/div/div/input")).sendKeys(data.get("probability"));
			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[6]/div[2]/div/div/input")).sendKeys(data.get("commission"));
			
			driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")).click(); //save button
			Thread.sleep(5000);
			//move to new deal page:
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div[5]"))).click().build().perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/a[3]/button")).click();
			

		}

		
	}

	@Then("^wants to close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
