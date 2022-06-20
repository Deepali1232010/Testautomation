package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.ZerodhaForgotPage;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;


     public class ForgotPageTest {

	 WebDriver   driver;
	 
	 @BeforeMethod
	 public void launchBrowser() {
		 driver = Browser.OpenBrowser();
	 }
	 @Test
	 public void ResetWithIRememberMyUserId() throws EncryptedDocumentException, IOException {
		 ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		 zerodhaLoginPage.clickOnForgotPassword();
		 
		 ZerodhaForgotPage zerodhaForgotPage = new ZerodhaForgotPage(driver);
		 String userId = Parametrization.getData(3, 1);
		 String pannumber = Parametrization.getData(4, 1);
		 String email = Parametrization.getData(6, 1);
		 zerodhaForgotPage.ClickOnIRememberMyUserId();
		 zerodhaForgotPage.EnterUserId(userId);
		 System.out.println(userId);
		 zerodhaForgotPage.EnterPannumber(pannumber);
		 zerodhaForgotPage.ClickOnEmailRadioButton();
		 zerodhaForgotPage.EnterEmail(email);
		 System.out.println(email);
		 zerodhaForgotPage.ClickOnResetButton();
		 zerodhaForgotPage.ClickOnBackToLogin();
	 }
	 @Test
	 public void ResetWithIForgotMyUserId() throws EncryptedDocumentException, IOException, InterruptedException {
		 ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		 zerodhaLoginPage.clickOnForgotPassword();
		 
		 ZerodhaForgotPage zerodhaForgotPage = new ZerodhaForgotPage(driver);
		 String pannumber = Parametrization.getData(4, 1); 
		 String email = Parametrization.getData(6, 1);
		 String captcha = Parametrization.getData(7, 1);
		 zerodhaForgotPage.ClickOnIForgotMyUserId();
		 zerodhaForgotPage.EnterPannumber(pannumber);
		 zerodhaForgotPage.ClickOnEmailRadioButton();
		 zerodhaForgotPage.EnterEmail(email);
		 zerodhaForgotPage.EnterCaptcha(captcha);
		 System.out.println(captcha);
		 Thread.sleep(3000);
		 zerodhaForgotPage.ClickOnResetButton();
		 zerodhaForgotPage.ClickOnBackToLogin();
	 }
	  @Test
	  public void ResetWithIForgotMyUserIdUsingSMS() throws EncryptedDocumentException, IOException {
			 ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
			 zerodhaLoginPage.clickOnForgotPassword();
			 
			 ZerodhaForgotPage zerodhaForgotPage = new ZerodhaForgotPage(driver);
			 String pannumber = Parametrization.getData(4, 1); 
			 String mob = Parametrization.getData(5, 1);
			 zerodhaForgotPage.ClickOnIForgotMyUserId();
			 zerodhaForgotPage.EnterPannumber(pannumber);
			 zerodhaForgotPage.ClickOnSmsRadioButton();
			 zerodhaForgotPage.EnterMobileNumber(mob);
			 zerodhaForgotPage.ClickOnResetButton();
			 zerodhaForgotPage.ClickOnBackToLogin();
	 
}
}