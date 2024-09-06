package Day_006_TestNG_DataProvider_Lab2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class Test10 {
	
	
	//Map<String, String> ColumnsData = new HashMap<String, String>();

	//Map<String, String> ColumnsData = new HashMap<String, String>();
	
	Map<String, HashMap<String, String>> Datatable = new HashMap<String, HashMap<String, String>>();
	
	@Test
	public void Test1()
	{
		HashMap<String, String> HM1 = new HashMap<String, String>();
		
		HM1.put("UserName", "SalesUser");
		HM1.put("Password", "Test123");
		HM1.put("Nationality", "Indian123");
		Datatable.put("TC01", HM1);
		
	
		
		HashMap<String, String> HM2 = new HashMap<String, String>();
		HM2.put("UserName", "Manager");
		HM2.put("Password", "Test124");
		HM2.put("Nationality", "Indian124");
		Datatable.put("TC02", HM2);
		
		
		
		System.out.println(Datatable.get("TC01").get("UserName"));
		System.out.println(Datatable.get("TC01").get("Password"));
		System.out.println(Datatable.get("TC01").get("Nationality"));
		
		System.out.println("***********----TC02 Test Data follows as-------*************");
		System.out.println(Datatable.get("TC02").get("UserName"));
		System.out.println(Datatable.get("TC02").get("Password"));
		System.out.println(Datatable.get("TC02").get("Nationality"));
	
		
		
		
	
	}

	

}
