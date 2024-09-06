package Madhu_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver Driver;
  @Test
  public void Amazon() throws Exception
  {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		Driver =new ChromeDriver();
		Driver.manage().window().maximize() ;
		Driver.get("https://www.facebook.com/");	  
		
		Driver.findElement(By.name("email")).sendKeys("");
		Driver.findElement(By.id("pass")).sendKeys("");
		Driver.findElement(By.name("login")).click();
  }
}
