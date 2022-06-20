package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POJO.Browser;
import POM.ZerodhaLoginPage;
import Utility.Parametrization;

public class LoginPageTest {
	
	WebDriver driver;
	@BeforeMethod
	public void browser() {
		driver =Browser.OpenBrowser();
	}
	
	@Test
	public void loginWithValidCredentialsTest() throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
	}
	@Test
	public void forgotPasswordLinkTest() {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgotPassword();
	}
	@Test
	public void signupLinkTest() {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp();
	}
	@Test
	public void ClickOnLoginWithoutDataTest() {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnLogin();
		String text=zerodhaLoginPage.getErrorText();
		System.out.println(text);
		String expectedText = "User ID should be minimum 6 characters.";
		Assert.assertEquals(text, expectedText);// hard Assertion
		zerodhaLoginPage.enterPassword("Velocity");
		
	}
	
	@Test
	public void clickOnLoginWithoutDataTest() throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnLogin();
		String text=zerodhaLoginPage.getErrorText();
		System.out.println(text);
		String expectedText = "User ID should be minimum 9 characters.";
		SoftAssert softassert = new SoftAssert ();
		softassert.assertEquals(text, expectedText);// soft Assert
		
		//zerodhaLoginPage.clickOnLogin();
		//zerodhaLoginPage.clickOnSignUp();
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		softassert.assertAll();
		zerodhaLoginPage.clickOnLogin();
		//softassert.assertAll();

	
}
}