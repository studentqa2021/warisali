package com.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
		public static void getLogin() throws Exception {
			
			//System.setProperty("webdriver.chrome.driver", "/Users/waris/Downloads/chromedriver");
			//WebDriver driver= new ChromeDriver();
		
		
			//System.setProperty("webdriver.chrome.driver", "/Users/waris/Downloads/chromedriver");
			
			WebDriverManager.chromedriver().setup();//THIS LINE AND System.setProperty IS SAME WORK
			
			WebDriver driver = new ChromeDriver();
			
			driver.navigate().to("https://demo.guru99.com/test/newtours/");
			
			//*[@class='mouseOut']//a ==> print all 4 text
			
			List<WebElement> topMenuText = driver.findElements(By.xpath("//*[@class='dropdown']/a"));//9
			
			//1/ print all items text ==> this ia the  orloop
			//for(int i=0;i<topMenuText.size();i++) //100 good
			
			//2/System.out.println(topMenuText.get(i).getText());
			//this is the java 8 foreach loop with lambda expression == more faster(lamda is a method)
			topMenuText.forEach(velue -> System.out.println(velue.getText()));//<== IT QA
			
			//3/this is java 8 stream API with peek() method.not practic  yeat
			//topMenuText.stream().peek(velue-> System.out.println(velue.getText()));
			
			
			//1/any specific object clack(example=i want to click namber 4 object 
			//i have weight topMenuText than dod than get  select namber of index(3) thn dod click  )
			//topMenuText.get(3).click();
			
			
			driver.quit();//this is for page quit
	
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
			
			
		
public static void main(String[] args) throws Exception {
	getLogin();
}
}
