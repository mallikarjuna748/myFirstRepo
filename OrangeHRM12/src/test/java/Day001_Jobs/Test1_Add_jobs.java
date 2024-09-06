package Day001_Jobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Add_jobs {
	
	WebDriver driver;
	
	//Step2
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String username="Admin",password="admin123";
	String JobTitle="Sales4",JobDescr="Sales4descr", JobNote="Sales4Note";
	
	
  @Test
  public void AddJobs() throws Exception{
	 

	  Test1_Add_jobs T1= new Test1_Add_jobs();

	  
	  	//Step3 We will pass input data to the methods
		T1.OpenChromeBrowser();
		T1.OpenOrangeHRM(TestURL);
		T1.Login(username,password);
		T1.Jobs_Add(JobTitle,JobDescr,JobNote);
		T1.CloseBrowser();
		

  }

  
  public void OpenChromeBrowser() throws Exception{
	  
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
  }
  
  
  public void OpenOrangeHRM(String TestURL1) throws Exception{
	  
		//Open Orange HRM
		//driver.get("https://opensource-demo.orangehrmlive.com/");
	    driver.get(TestURL1);
  }
  
  public void Login(String username1,String password1) throws Exception{
	  
		//Login
		findElement(By.id("txtUsername")).sendKeys(username1);
		findElement(By.id("txtPassword")).sendKeys(password1);
		findElement(By.id("btnLogin")).click();
  }
  
  public void Jobs_Add(String JobTitle,String JobDescr,String JobNote) throws Exception{
	  
		//Add_jobs
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
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
