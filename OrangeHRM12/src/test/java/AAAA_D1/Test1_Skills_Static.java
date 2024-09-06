package AAAA_D1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Skills_Static {
	
	
	static WebDriver driver;
	
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String SkillName="Java19",SkillDescr="Java19 descr";
	
  @Test
  public void SkillsTest() throws Exception {
	  
	  //Test1_Skills_Static T1= new Test1_Skills_Static();
	  
	  Test1_Skills_Static.OpenChromeBrowser();
	  Test1_Skills_Static.OpenOrangeHRM(TestURL);
	  Test1_Skills_Static.Login(UserName,Password);
	  Test1_Skills_Static.AddSkills(SkillName,SkillDescr);
	  Test1_Skills_Static.CloseBrowser();
	  
  }
  
  
  
  public static void OpenChromeBrowser() throws Exception
  {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
  }
  
  
  
  public static void OpenOrangeHRM(String TestURL1) throws Exception
  {
		driver.get(TestURL1);
  }
  
  
  public static void Login(String UserName1,String Password1) throws Exception
  {
		
		findElement(By.id("txtUsername")).sendKeys(UserName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
		
  }
   
  
  public static void AddSkills(String SkillName,String SkillDescr) throws Exception
  {
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
		findElement(By.id("btnSave")).click();
  }
  
  public static void CloseBrowser() throws Exception
  {
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
