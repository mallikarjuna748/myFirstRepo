package AAAAAA_DAY2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Login {
	
	
	WebDriver driver;
	
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin" , Password="admin123";
	String NationalityText="Indian123";
	
	
	
  @Test
  public void Login_Test() throws Exception{
	  
	  TC01_Login T1=new TC01_Login();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UserName,Password);
	  T1.AddNationalities(NationalityText);
	  T1.CloseBrowser();	

  }
  
  
  
  public void OpenChromeBrowser() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
 public void OpenOrangeHRM(String TestURL) throws Exception{
	  
		//driver.get("https://opensource-demo.orangehrmlive.com/");
	 
	 driver.get(TestURL);
  }
  
 public void Login(String UserName,String Password) throws Exception{

		findElement(By.name("txtUsername")).sendKeys(UserName);
		findElement(By.name("txtPassword")).sendKeys(Password);
		findElement(By.name("Submit")).click();
		
 }
 
 
 
 
 public void AddNationalities(String NationalityText) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(NationalityText);
		findElement(By.id("btnSave")).click();
	 
 }
 
 public void CloseBrowser() throws Exception{
	  
	 driver.quit();
 }
  
  
  public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
  
  
  
  
}
