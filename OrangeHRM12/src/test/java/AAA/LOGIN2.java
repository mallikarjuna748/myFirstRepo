package AAA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LOGIN2 

{
	
	WebDriver driver;
  @Test
  public void Login() throws Exception
  {
	  
	//Launch Browser
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			//open orangehrm
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.xpath("//*[@id=\'menu_pim_viewPimModule\']/b")).click();
			driver.findElement(By.xpath("//*[@id=\'menu_pim_addEmployee\']")).click();
			driver.findElement(By.id("photofile")).sendKeys("D:\\anil.jpg");
			//*[@id="menu_pim_addEmployee"]
  }
}
