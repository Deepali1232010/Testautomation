package Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import POM.ZerodhaSignupNowPage;
import Utility.Parametrization;

public class SignupPageTest {
	WebDriver driver;
	
  @BeforeMethod
  public void launchBrowser() {
	  driver = Browser.OpenBrowser();
  }
  @Test
  public void signupWithValidCredentials() throws EncryptedDocumentException, IOException {
	  ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
	  zerodhaLoginPage.clickOnSignUp();
	  Set<String> address = driver.getWindowHandles();
	  System.out.println(address);
	  Iterator<String> i = address.iterator();
	  
	  while(i.hasNext()) {
		  String add = i.next();
		  driver.switchTo().window(add);
		  String currentTitle= driver.getTitle();
		  System.out.println(currentTitle);
		  if(currentTitle.equals("Signup and open a Zerodha trading and demat account online and start investing – Zerodha"))
		  {
			  ZerodhaSignupNowPage zerodhaSignupNowPage = new ZerodhaSignupNowPage(driver);
				  String mob = Parametrization.getData(5, 1);
				  zerodhaSignupNowPage.MobileNumber(mob);
				  System.out.println(mob); 
				  zerodhaSignupNowPage.ClickOnContinueButton();
				  zerodhaSignupNowPage.ClickOnNriAccountButton();
				  
		  }
	  }
	
	 }
       /* @Test
        public void NirLinkValidation() {
        	ZerodhaSignupNowPage zerodhaSignupNowPage = new ZerodhaSignupNowPage(driver);
        	zerodhaSignupNowPage.ClickOnNriAccountButton();
        	
        }*/
   
 
}
