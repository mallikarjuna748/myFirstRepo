package AAAA_Y_Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
	
	
	WebDriver driver;
	
  @Test
  public void LoginTest() {
	  
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
		
	  
	
	  
  }
  


  
}
