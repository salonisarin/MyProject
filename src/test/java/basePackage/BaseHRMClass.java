package basePackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseHRMClass {

	public static Properties prop= new Properties();	
	public static WebDriver driver;
	//step 1 to create constructor
	
	public BaseHRMClass()  {
	
    try {
	FileInputStream file= new FileInputStream("C:\\Users\\sarin\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
     prop.load(file);
} 

    catch (FileNotFoundException e) {
	
	e.printStackTrace();
}
    catch(IOException a) {
	a.printStackTrace();
}
	}
	//step 2 method
   public static void initiate() {
	//driver path
	   //max page load,implicit,getting url
	   //
	 String browsername= prop.getProperty("browser");
	 if (browsername.equals("Firefox")) {
		 System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		 driver= new FirefoxDriver();
		 }
		 else if(browsername.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 ChromeOptions op=new ChromeOptions();
			 op.addArguments("--remote-allow-origins=*");
				
			  driver=new ChromeDriver(op);
		//	 driver=new ChromeDriver();
		 }
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
	// Thread.sleep(500);
	 driver.get(prop.getProperty("Url"));
	 }
   
   public static void screenshots(String Filename) {
	File file=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(file, new File("C:\\Users\\sarin\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots" + Filename+".jpg"));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
   }
}
	

	
		
	

