package AAAA_Customers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Login_Parameters_Static {
	
	
	static WebDriver driver;
	
	//Step2 - Global Variable
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String NationalityText="Indian768";
	
	
  @Test
  public void Login_Test() throws Exception{
	  
	  TC01_Login_Parameters_Static.OpenChromeBrowser();
	  TC01_Login_Parameters_Static.OpenOrangeHRM(TestURL);     //step3
	  TC01_Login_Parameters_Static.Login(UserName,Password);   //step3
	  TC01_Login_Parameters_Static.AddNationalities(NationalityText);  //step3
	  TC01_Login_Parameters_Static.CloseBrowser();	

  }
  
  
  
  public static void OpenChromeBrowser() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
 public static void OpenOrangeHRM(String TestURL) throws Exception{
	  
		driver.get(TestURL);
  }
  
 public static void Login(String UserName,String Password) throws Exception{
	  
		
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
 }
 
 public static void AddNationalities(String NationalityText) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(NationalityText);
		findElement(By.id("btnSave")).click();
	 
 }
 
 public static void CloseBrowser() throws Exception{
	  
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
