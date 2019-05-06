package searchUIFunctionality;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ClearSearch {
  
	//create an object on WebDriver class
	WebDriver WD1;
	//Declare String variable to store the web URL
	String baseURL;
	
	@BeforeMethod
	  public void beforeMethod() {
		
		System.out.println("this method initializes the variables/properties and opens the web browser");
		
		//Get the path below where Chrome driver application is located
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shilpamadhuri_r\\Documents\\chromedriver.exe");
		
		//initialize the web driver browser to point to chrome
		WD1 = new ChromeDriver();
		
		//store the link to the website in the baseURL variable
		baseURL = "https://www.google.com/";
		
		//maximize the window 
		WD1.manage().window().maximize();
		
		//open the web url
		WD1.get(baseURL);
		
		//wait for 1second
		WD1.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	}
	
	@Test
    public void clearStringandSendNewString() {
	   	
		//Declare and initialize strings to be used in google search
		String String1 = "relayr";
		String String2 = "Equipment-as-a-Service";
		
		//locate the search bar by xpath
		WD1.findElement(By.xpath("//input[@name='q']")).click();
		
		//provide keys to search
		WD1.findElement(By.xpath("//input[@name='q']")).sendKeys(String1);
		
		//press ENTER key to search
		WD1.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
		//Wait for 1 second
		WD1.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		
		//clear the String1 in the search bar
		WD1.findElement(By.xpath("//div[@class='a4bIc']//input[@name='q']")).clear();
		
		//provide new keys to search
		WD1.findElement(By.xpath("//div[@class='a4bIc']//input[@name='q']")).sendKeys(String2);
		
		//press ENTER to search
		WD1.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println(" we are in the after method");
	  //WD1.quit();
  }

}
