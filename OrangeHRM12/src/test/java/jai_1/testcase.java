package jai_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testcase {
	WebDriver Driver;
  @Test
   
  
 public void OpenChromeBrowser() throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		Driver =new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://opensource-demo.orangehrmlive.com/");		
	  Driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  Driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  Driver.findElement(By.id("btnLogin")).click();
	  
	  Driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	  Driver.findElement(By.id("menu_admin_Job")).click();
	  Driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
	  Driver.findElement(By.id("btnAdd")).click();
	  Driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("admin123");
	  Driver.findElement(By.id("btnSave")).click();
	  
	  
}
}