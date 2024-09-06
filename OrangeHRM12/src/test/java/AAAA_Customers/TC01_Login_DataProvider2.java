package AAAA_Customers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Login_DataProvider2 {
	
	
	WebDriver driver;
	
	//Step2 - Global Variable
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String NationalityText="Indian768";
	
	
	//Step1
	//step1
		 @DataProvider(name = "Orange1")
		  public static Object[][] Test1() throws Exception {
			 
			 Object[][] data = new Object[2][4];

				// 1st row
				data[0][0] ="https://opensource-demo.orangehrmlive.com/";
				data[0][1] = "Admin";
				data[0][2] = "admin123";
				data[0][3] = "Indians227";

				// 2nd row
				data[1][0] ="https://opensource-demo.orangehrmlive.com/";
				data[1][1] = "Admin";
				data[1][2] = "admin123";
				data[1][3] = "Indians228";
				
				return data;
		       
		  }
		 
	 
	
	
  @Test(dataProvider="Orange1")//Step2
  public void Login_Test(String TestURL,String UserName,String Password,String NationalityText ) throws Exception{ //Step3
	  
	  TC01_Login_DataProvider2 T1=new TC01_Login_DataProvider2();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);     //step3
	  T1.Login(UserName,Password);   //step3
	  T1.AddNationalities(NationalityText);  //step3
	  T1.CloseBrowser();	

  }
  
  
  
  public void OpenChromeBrowser() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
 public void OpenOrangeHRM(String TestURL) throws Exception{
	  
		driver.get(TestURL);
  }
  
 public void Login(String UserName,String Password) throws Exception{
	  
		
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
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
