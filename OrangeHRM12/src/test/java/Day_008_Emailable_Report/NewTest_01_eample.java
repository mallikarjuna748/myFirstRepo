package Day_008_Emailable_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class NewTest_01_eample {
	
	WebDriver driver;
	
	public String username="//*[@id=\'email\']";
	public String password="//*[@id=\'pass\']";
	//public String login="//*[@id=\'u_0_d_5w\']";
	
	
  @Test
  public void Emailable_report() throws Exception {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  
	  String TestURL="https://www.facebook.com/";
	  
	  driver.get(TestURL);
	  Reporter.log("Open facbook");
	  driver.findElement(By.xpath(username)).sendKeys("9676353365");
	  Reporter.log("pass enter username ");
	  driver.findElement(By.xpath(password)).sendKeys("buva225");
	  Reporter.log("pass enter password ");
	  driver.findElement(By.name("login")).click();
	  Reporter.log("pass click on login ");
	
	
  }
  
}
