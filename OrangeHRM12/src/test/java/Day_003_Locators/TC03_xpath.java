package  Day_003_Locators;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC03_xpath
{
	

	
	static WebDriver driver=null;
	

	
	
	

	
	public static String  UserName="//*[@id='txtUsername']";
	public static String  Password="//*[@id='txtPassword']";
	public static String  Loginbutton="//*[@id='btnLogin']";
	public static String  Admin="//*[@id='menu_admin_viewAdminModule']/b";
	public static String  Nationality="//*[@id='menu_admin_nationality']";

	@Test
	
	
	public void Test2() throws Exception {
		
	
		
		
		driver = TestBrowser.OpenChromeBrowser();
		
		
		//driver=driver1;
		
		//driver = TestBrowser.OpenIEBrowser();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	
		findElement(By.xpath(UserName)).sendKeys("Admin");
		findElement(By.xpath(Password)).sendKeys("admin123");
		findElement(By.xpath(Loginbutton)).click();
		
		findElement(By.xpath(Admin)).click();
		findElement(By.xpath(Nationality)).click();

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












