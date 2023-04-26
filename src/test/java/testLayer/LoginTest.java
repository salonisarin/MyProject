package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass{
	
	PomLogin login;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshots("Login");
		login=new PomLogin();
	}

	

	@Test(priority=1)
	public void Title() {
		String actual=login.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
	}
	
	
	  @DataProvider public Object[][] Details(){ Object
	  result[][]=ExcelSheet.readdata("Sheet1"); return result; }
	  
	  @Test(priority=2, dataProvider="Details") public void Login(String
	  name,String password) throws InterruptedException {
		  login.typeusername(name);
	     Thread.sleep(6000); 
	       login.typepassword(password); 
	  // login.clickbtn(); 
	  }
	 
	
	@AfterMethod
	public void close() {
		driver.close();
		

	}
}
