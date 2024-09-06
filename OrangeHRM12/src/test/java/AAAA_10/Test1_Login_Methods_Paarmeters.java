package AAAA_10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Login_Methods_Paarmeters {
	
	WebDriver driver;
	
	//Step2
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String SkillName="Oracle",SkillDescr="Oracle descr";
	
	
  @Test
  public void LoginTest() throws Exception{
	  

	  Test1_Login_Methods_Paarmeters T1=new Test1_Login_Methods_Paarmeters();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UserName,Password);
	  T1.Add_Skills(SkillName,SkillDescr);
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
  
  public void OpenOrangeHRM(String TestURL) throws Exception{
	  

		//driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.get(TestURL);
		
  }
  
  public void Login(String UserName,String Password) throws Exception{
	  
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
  }
  
  
  public void Add_Skills(String SkillName,String SkillDescr) throws Exception{
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
		findElement(By.id("btnSave")).click();
		
  }
  
  public void CloseBrowser() throws Exception{
	  
		driver.quit();
  }
  
  
  
}
