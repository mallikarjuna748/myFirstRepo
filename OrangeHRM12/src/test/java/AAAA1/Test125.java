package AAAA1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test125 {
	
 
	static WebDriver driver;
	
  @Test
  public void LoginTest() throws Exception {
	  
	  
		
	  Test125.OpenChromeBrowser();
	  Test125.OpenOrangeHRM();
	  Test125.Login();
	  Test125.AddJobs();
	  Test125.CloseBrowser();
	 
		
  }
  
  
  public static void OpenChromeBrowser() throws Exception {
	  
	  		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
  }
  
  public static void OpenOrangeHRM() throws Exception {
	  
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  public static void Login() throws Exception {
		
	findElement(By.id("txtUsername")).sendKeys("Admin");
	findElement(By.id("txtPassword")).sendKeys("admin123");
	findElement(By.id("btnLogin")).click();
  }
  
  public static void AddJobs() throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales5");;
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales5 descr");
		findElement(By.id("jobTitle_note")).sendKeys("Sales Note5");
		findElement(By.id("btnSave")).click();
  }
  
  public static void CloseBrowser() throws Exception {
	  
	  driver.quit();
	  
  }
  
  
  
  
  
  
  
  public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

  
  
  
  
  
  
}
