package AAAA2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Add_jobs_Parameters2 {
	
	WebDriver driver;
	
	//Step 2  - Global Variables
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String JobTitle="Sales1",JobDescr="Sales1 descr",JobNote="Sales1Note";
	
	//Step1
	 @DataProvider(name = "Orange2")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales1","Sales1 descr","Sales1Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales2","Sales2 descr","Sales2Note" },
	         	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales3","Sales3 descr","Sales3Note" }
	        	};
	        	
	  }
	 
	 
	 
	 @DataProvider(name = "Orange1")//Step2
	  public static Object[][] DataProvider111() throws Exception {
		 
		 Object[][] data = new Object[3][6];

			// 1st row
			data[0][0] ="https://opensource-demo.orangehrmlive.com/";
			data[0][1] = "Admin";
			data[0][2] = "admin123";
			data[0][3] = "Sales4";
			data[0][4] = "Sales4 Descr";
			data[0][5] = "Sales4 Note";

			// 2nd row
			data[1][0] ="https://opensource-demo.orangehrmlive.com/";
			data[1][1] = "Admin";
			data[1][2] = "admin123";
			data[1][3] = "Sales5";
			data[1][4] = "Sales5 Descr";
			data[1][5] = "Sales5 Note";
			
			data[2][0] ="https://opensource-demo.orangehrmlive.com/";
			data[2][1] = "Admin";
			data[2][2] = "admin123";
			data[2][3] = "Sales6";
			data[2][4] = "Sales6 Descr";
			data[2][5] = "Sales6 Note";


			
			return data;
	       
	  }
	 
	
	 @Test(dataProvider="Orange4")//Step2
	 public void Test1(String TestURL,String UserName,String Password,String JobTitle,String JobDescr,String  JobNote  ) throws Exception
	 {
		 TC01_Add_jobs_Parameters2 T1= new TC01_Add_jobs_Parameters2();
		 
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
