package com.cucumber.stedef;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.generic.PageFactoryLogin;
import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdf{
	WebDriver driver;
	PageFactoryLogin obj;
	@Given("Open browser")
	public void getBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@And("go to Application URL")
	public void getURL() throws Exception{
		driver.get(BaseConfig.getData("URL"));
		driver.manage().window().maximize();
	}

	@When("put valid user name")
	public void getUsername() throws Exception {
		 obj=new PageFactoryLogin (driver);
		Highlighter.getColor(obj.getUser(), driver, "red");
		obj.getUser().sendKeys(BaseConfig.getData("user"));
	}
	@And("put valid password")
	public void getPassword() throws Exception {
		Highlighter.getColor(obj.getPassword(), driver);
		obj.getPassword().sendKeys(BaseConfig.getData("password"));
		
	}
	@And("click signin button")
	public void clickSignin() {
		Highlighter.getColor(obj.getSubmitButton(), driver);
		obj.getSubmitButton().click();
		
	}

	@Then("login should be successfull and showed sign out button")
	public void checkSigninvalidation() throws Throwable {
		ScreenShot.getScreenShot(driver, "Login Test status");
		Assert.assertEquals(obj.getLoginStatusSuccessMsg().getText(), "Login Successfully");// fail=stop
		Assert.assertTrue(obj.getSignOffList().get(7).isDisplayed());// stopped here

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(obj.getSignOffList().get(7).isDisplayed());

		soft.assertAll();
	}

	@And("close browser")
	public void closeBrowser() {

		driver.quit();
	}
	
}
