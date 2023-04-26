package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
// object repository
	
 @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input") //driver.FindElement(By.
 WebElement Username;
 @FindBy(name="password") 
 WebElement Password;
 @FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
 WebElement Loginbtn;
 
 //initiate page elements
 
 public PomLogin() {
	 
	 PageFactory.initElements(driver, this);
 }
 
 public void typeusername(String name) {
	 Username.sendKeys(name);
 }
 
 public void typepassword(String pass) {
	 Password.sendKeys(pass);
 }
 public void clickbtn() {
	 Loginbtn.click();
	 
 }
 public String verify() {
	 return driver.getTitle();
 }
}
