package ABC_Demo5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC01_Login_DataProvider3 {
	
	static WebDriver driver;
	
	//step1
	//String UserName="Admin",Password="admin123";
	//String Nationality_text="Indian899";
	
	
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality15.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	@Test (dataProvider="TC01_Add_Nationality")
	public void loginTest(String Browser,String TestURL,String UserName,String Password,String Nationality_text) throws Exception
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			 driver=TestBrowser.OpenChromeBrowser();
			
			//driver=driver1;
		 	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
				driver = TestBrowser.FirefoxBrowser();
				Thread.sleep(10000);
		}
		
		//TC01_Login_DataProvider3.OpenChromeBroswer();
		TC01_Login_DataProvider3.OpenOrangeHRM(TestURL);
		TC01_Login_DataProvider3.Login(UserName,Password); //step2
		//TC01_Login_DataProvider3.AddNationalities(Nationality_text);//stp2
		TC01_Login_DataProvider3.CloseBrowser();
	}
	
	
	public static void OpenChromeBroswer() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
	}
	
	public static void OpenOrangeHRM(String TstURL1) throws Exception
	{
		driver.get(TstURL1);
	}
	

	public static  void Login(String UserName1,String Password1) throws Exception //step3
	{
		findElement(By.id("txtUsername")).sendKeys(UserName1);  //step4
		findElement(By.id("txtPassword")).sendKeys(Password1);  //step4
		findElement(By.id("btnLogin")).click();
	}
	

	public static void AddNationalities(String Nationality_text1) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality_text1);//step4
		findElement(By.id("btnSave")).click();
	}
	

	public static void CloseBrowser() throws Exception
	{
		driver.quit();
	}
	

	
	
	
	
	public static WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

	

}
