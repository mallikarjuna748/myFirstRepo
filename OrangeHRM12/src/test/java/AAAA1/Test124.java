package AAAA1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test124 {
	
 
	WebDriver driver;
	
  @Test
  public void LoginTest() throws Exception {
	  
	  Test124 T2= new Test124();
		
	  T2.OpenChromeBrowser();
	  T2.OpenOrangeHRM();
	  T2.Login();
	  T2.AddJobs();
	  T2.CloseBrowser();
	 
		
  }
  
  
  public void OpenChromeBrowser() throws Exception {
	  
	  		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
  }
  
  public void OpenOrangeHRM() throws Exception {
	  
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  public void Login() throws Exception {
		
	findElement(By.id("txtUsername")).sendKeys("Admin");
	findElement(By.id("txtPassword")).sendKeys("admin123");
	findElement(By.id("btnLogin")).click();
  }
  
  public void AddJobs() throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales5");;
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales5 descr");
		findElement(By.id("jobTitle_note")).sendKeys("Sales Note5");
		findElement(By.id("btnSave")).click();
  }
  
  public void CloseBrowser() throws Exception {
	  
	  driver.quit();
	  
  }
  
  
  
  
  
  
  
  public   WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

  
  
  
  
  
  
}
