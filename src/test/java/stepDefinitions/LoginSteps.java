package stepDefinitions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
	    //throw new io.cucumber.java.PendingException();
	}
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
	    //throw new io.cucumber.java.PendingException();
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {       
        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();
	    //throw new io.cucumber.java.PendingException();
	}
	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
        Assert.assertTrue(element.isDisplayed(), "Dashboard is not displayed");
	    //throw new io.cucumber.java.PendingException();
	}
}