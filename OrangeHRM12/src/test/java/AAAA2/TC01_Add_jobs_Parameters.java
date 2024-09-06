package AAAA2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Add_jobs_Parameters {
	
	WebDriver driver;
	
	//Step 2  - Global Variables
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String JobTitle="Sales1",JobDescr="Sales1 descr",JobNote="Sales1Note";
	
	//Step1
	 @DataProvider(name = "Orange1")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales1","Sales1 descr","Sales1Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales2","Sales2 descr","Sales2Note" },
	         	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales3","Sales3 descr","Sales3Note" }
	        	};
	  }
	 
	
	 @Test(dataProvider="Orange1")//Step2
	 public void Test1(String TestURL,String UserName,String Password,String JobTitle,String JobDescr,String  JobNote  ) throws Exception
	 {
		 TC01_Add_jobs_Parameters T1= new TC01_Add_jobs_Parameters();
		 
		 T1.OpenChromeBrowser();
		 T1.OpenOrangeHRM(TestURL);
		 T1.Login(UserName,Password);
		 T1.AddJobs1(JobTitle,JobDescr,JobNote);
		 
	 }
  
  public void OpenChromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public void OpenOrangeHRM(String TestURL) throws Exception
  {
		//Open Orange HRM
		//driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.get(TestURL);
  }
  
  
  
  
  public void Login(String UserName,String Password) throws Exception
  {
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
  }
  
  
  
  
  public void AddJobs1(String JobTitle,String JobDesc,String JobNote) throws Exception
  {
		//AddJobs
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDesc);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		findElement(By.id("btnSave")).click();
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
