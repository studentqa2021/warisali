package com.generic;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
	 static Logger log= Logger.getLogger(BaseLogin.class.getName());
		public static void getlogin(){//first i need to create a method 
		
		WebDriverManager.chromedriver().setup(); //(2) this is code for open a browser
	    WebDriver Driver = new ChromeDriver();//(3)
	    Driver.get("http://automationpractice.com/index.php");//(4)this line also  will go my application
	    Driver.navigate().to("http://automationpractice.com/index.php");;//(4) this line will go my application
	    
		 //this 3 waiting code i have write only one time and use after the URL code.
//	    Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//(9)HTML dome page is loaded or not loaded,
//	    Driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));//(9)f anything asynchronous problem it is wait.
//		Driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//(9) UI Element page is loaded or not loaded..
	//	

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//(9) UI Element page is loaded or not loaded..
		Driver.manage().window().maximize();//(5)
		
		WebElement signInButton= Driver.findElement(By.xpath("//*[@class='login']"));//(6)
		((JavascriptExecutor)Driver).executeScript("arguments[0].style.border='3px solid red ",signInButton);
		WebDriverWait waite =new WebDriverWait(Driver,Duration.ofSeconds(30));
		waite.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();//(7)
		log.info("this login page");
		//Thread.sleep(3000);// slow down for 3 sec
		
		WebElement email = Driver.findElement(By.xpath("//*[@id='email']"));//(7)
		((JavascriptExecutor)Driver).executeScript("arguments[0].style.border='3px solid ",email);
		waite.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys("sarowerny@gmail.com");//prob
		log.info("this is email");
		
		WebElement password = Driver.findElement(By.xpath("//*[@name='passwd']"));//(7)/prob
		((JavascriptExecutor)Driver).executeScript("arguments[0].style.border='3px solid ",password);
		waite.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("student");// crime
		log.info("this is password");
		
		WebElement signInBtn= Driver.findElement(By.xpath("//*[@id='SubmitLogin']"));//(7)prob
		((JavascriptExecutor)Driver).executeScript("arguments[0].style.border='3px solid ",signInBtn);
		waite.until(ExpectedConditions.elementToBeClickable(signInBtn));
		signInBtn.click();
		log.info("this is signInBtn");
		
		Driver.quit();//(8)this code for windows close.	
		
		
		}
	public static void main(String[] args) { // here i create a main method for call other method.
		BaseLogin.getlogin();


	    }
}
		
			//driver.get(BaseConfig.getData("URL"));
		
			//driver.manage().window().maximize();//this line for maximize the page.
			
			//PageFactoryLogin mpf= new PageFactoryLogin(driver);
	        
		//Highlighter.getColor(mpf.getUsername(), driver, "red");
		  // mpf.getUsername().sendKeys(BaseConfig.getData("user"));
		
		 //   Highlighter.getColor(mpf.getPassword(), driver, "blue");
		  //  mpf.getPassword().sendKeys(BaseConfig.getData("password"));
			
		   // Highlighter.getColor(mpf.submitbutton(), driver);
		   // mpf.submitbutton().click();
		    
		   // Thread.sleep(3000);
		  //driver.quit();
			
			
	
