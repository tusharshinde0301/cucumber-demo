package stepDefinitions;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {
	
	WebDriver driver;
	
	@Given("User is already on Login Page")
	public void user_is_already_on_Login_Page() {
		// System Property for Chrome Driver
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
	}

	@When("title of Login Page is Cogmento CRM")
	public void title_of_Login_Page_is_Cogmento_CRM() {
		Assert.assertEquals("Cogmento CRM", driver.getTitle());
	}

	@Then("User enters username and password")
	public void user_enters_username_and_password() {
		driver.findElement(By.name("email")).sendKeys("kapil_negi67@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("Freecrm@2020");
	}

	@Then("User enters credentials")
	public void user_enters_credentials(DataTable credentials) {
		List<List<String>> data = credentials.cells(); //returns list of list of strings
		System.out.println("DATA = " + data);
		driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	}

//	@Then("User enters \"(.*)\" and \"(.*)\"")
//	public void user_enters_credentials() {
//		driver.findElement(By.name("email")).sendKeys("kapil_negi67@yahoo.com");
//		driver.findElement(By.name("password")).sendKeys("Freecrm@2020");
//	}

	@Then("User enters \"(.*)\" and \"(.*)\"")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("User clicks on Login button")
	public void user_clicks_on_Login_button() {
		driver.findElement(By.cssSelector("div.ui.fluid.large.blue.submit.button")).click();
	}

	@Then("User is on Home Page")
	public void user_is_on_Home_Page() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='user-display'][text()='kapil negi']"));
	}

	@Then("close the browser")
	public void close_the_browser() {
	    driver.quit();
	}
	
}
