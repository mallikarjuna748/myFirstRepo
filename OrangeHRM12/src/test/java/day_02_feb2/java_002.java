package day_02_feb2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sun.tools.xjc.Driver;

public class java_002 {
	
	WebDriver driver;
	

	
  @Test
  public void LoginTest() throws Exception
	{
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	  
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
	
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("java123");
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("java_dec");
		
		driver.findElement(By.id("jobTitle_note")).sendKeys("java note");
		driver.findElement(By.id("btnSave")).click();
		
		
		
		
		
		
		
		
		
  }
  
}
