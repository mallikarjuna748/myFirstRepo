package AAAA_10;

import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Test1_Login {
	
	WebDriver driver;
	
  @Test
  public void LoginTest() throws Exception{
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://Google.com");
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Amazon prime video");
		Thread.sleep(3000);
		 List<WebElement> options = driver.findElements(By.xpath("//li[@jsaction='click:.CLIENT;mouseover:.CLIENT']"));

	        // Get the count of elements
	        int options_count = options.size();
	        System.out.println("Number of Suggestions: " + options_count);

	        // Iterate through the list and print the text of each element
	        for (WebElement option : options) {
	            String optionText = option.getText();
	            System.out.println(optionText);
	        }
		
	  	/*	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Qualifications")).click();
		driver.findElement(By.id("menu_admin_viewSkills")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("skill_name")).sendKeys("Java15");
		driver.findElement(By.id("skill_description")).sendKeys("Java15 descr");
		driver.findElement(By.id("btnSave")).click();*/
		
		driver.quit();
		
	  
  }
  
  
  
  
  
}
