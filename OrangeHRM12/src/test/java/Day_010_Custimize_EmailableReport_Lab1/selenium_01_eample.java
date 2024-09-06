package Day_010_Custimize_EmailableReport_Lab1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class selenium_01_eample {
	
	WebDriver driver;
	Reporter1 R1;
	
	public String username="//*[@id=\'email\']";
	public String password="//*[@id=\'pass\']";

  @Test
  public void Emailable_report() throws Exception {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  
	  String sel = "selenium";
	  R1=new Reporter1(driver,sel);
	  
	  String TestURL="https://www.facebook.com/";
	  
	  driver.get(TestURL);
	  R1.TakeScreenShotAuto(driver,"Opened facebook","Pass");
	  findElement(By.xpath(username)).sendKeys("9676353365");
	  R1.TakeScreenShotAuto(driver,"user name entred","Pass");
	  findElement(By.xpath(password)).sendKeys("bava225");
	  R1.TakeScreenShotAuto(driver,"password entred","Pass");
	  findElement(By.name("login")).click();
	  R1.TakeScreenShotAuto(driver,"login","Pass");
	  driver.close();
	
  }
  

public  WebElement findElement(By by) throws Exception 
{
			
	 WebElement elem = driver.findElement(by);    	    
	// draw a border around the found element
	 
	if (driver instanceof JavascriptExecutor) 
	{
	 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 
	}
	
	return elem;
}
}