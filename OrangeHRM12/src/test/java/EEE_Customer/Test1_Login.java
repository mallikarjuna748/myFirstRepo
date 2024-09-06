package EEE_Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Login {
	
	WebDriver driver;
	
  @Test
  public void TestLogin()throws Exception {
	  
	
	  Test1_Login T1= new Test1_Login();
	  
	  T1.OpenChromeBroser();
	  T1.OpenOrangeHRM();
	  T1.Login();
	  T1.AddJobs();
	  T1.CloseBrowser();
		

	  
  }
  
  
  public void OpenChromeBroser()throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
 public void OpenOrangeHRM()throws Exception {
	  
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
 
 public void Login()throws Exception {

		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
 }
 
 
 public void AddJobs()throws Exception {
	 
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales11");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales11 Descr");
		findElement(By.id("jobTitle_note")).sendKeys("Sales11 Note");
		findElement(By.id("btnSave")).click();	
	 
 }
 
 public void CloseBrowser()throws Exception {
	 
	 driver.quit();
	  
 }
 
 
  
  public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;
	}

  
  
  
}
