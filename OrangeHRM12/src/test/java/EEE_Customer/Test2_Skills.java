package EEE_Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test2_Skills {
	
	WebDriver driver;
	
  @Test
  public void AddSkillsTest() throws Exception {
	  
	  Test2_Skills T3= new Test2_Skills();
	  T3.OpenChromeBrowser();
	  T3.OpenOrangeHRM();
	  T3.Login();
	  T3.AddSkills();
	  T3.CloseBrowser();
	
		
  }
  
  public void OpenChromeBrowser() throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  public void OpenOrangeHRM() throws Exception {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/"); 
  
  public void Login() throws Exception {
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
  }
  
 public void AddSkills() throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewLanguages")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("language_name")).sendKeys("JAVA7");
		findElement(By.id("btnSave")).click();
  }
 menu_admin_viewAdminModule
 	
 
public void CloseBrowser() throws Exception {
	
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
