package AAAA_10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Login_Methods {
	
	WebDriver driver;
	
  @Test
  public void LoginTest() throws Exception{
	  

	  Test1_Login_Methods T1=new Test1_Login_Methods();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM();
	  T1.Login();
	  T1.Add_Skills();
	  T1.CloseBrowser();

	  
		  
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

  
  
  public void OpenChromeBrowser() throws Exception{
  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public void OpenOrangeHRM() throws Exception{
	  

		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  public void Login() throws Exception{
	  
		

		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
		
  }
  
  
  public void Add_Skills() throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("Java18");
		findElement(By.id("skill_description")).sendKeys("Java18 descr");
		findElement(By.id("btnSave")).click();
		
  }
  
  public void CloseBrowser() throws Exception{
	  
		driver.quit();
  }
  
  
  
}
