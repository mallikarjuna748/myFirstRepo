package Day_006_TestNG_DataProvider_Lab2;

import org.testng.annotations.Test;

public class Test9 {


		private String TestCase, UserName, Password, Nationality;

		public String getTestCase() {
			return TestCase;
		}

		public void setTestCase(String testCase) {
			TestCase = testCase;
		}

		public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public String getNationality() {
			return Nationality;
		}

		public void setNationality(String nationality) {
			Nationality = nationality;
		}

		
		@Test
		public void Test1() throws Exception
		{
			Test9 T1=new Test9();
			
			T1.TestCase="TC01";
			T1.UserName="Admin";
			T1.Password="admin123";
			T1.Nationality="Indian121";
			
			System.out.println(T1.getTestCase());
			System.out.println(T1.getNationality());
			
			Test9 T2=new Test9();
			T2.TestCase="TC02";
			T2.UserName="Admin";
			T2.Password="admin123";
			T2.Nationality="Indian122";
			
			System.out.println(T2.getTestCase());
			System.out.println(T2.getNationality());
			
		}



}
