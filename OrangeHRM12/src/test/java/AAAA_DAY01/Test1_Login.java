package AAAA_DAY01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Login {
	
	
	WebDriver driver;
	
  @Test
  public void LoginTest() throws Exception {
	  
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		//open orangehrm
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(5000);
		
		findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(5000);
		
		findElement(By.id("btnLogin")).click();

  }
  
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	        
	 
		}
		return elem;
	}
  
  
}
