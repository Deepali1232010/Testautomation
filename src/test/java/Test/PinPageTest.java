package Test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POJO.Browser;

import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;

@Listeners(TestListeners.class)
public class PinPageTest extends BaseTest {

	//WebDriver driver;
	
	//int a = 0;
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser();
	}
	/*@AfterMethod
	public  void screenshot() throws IOException {
		
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\Velocity\\Automation\\Screenshot\\"+a+".png");
		
		FileHandler.copy(source, destination);
		a++;
		
		}
*/
		@Test
		public void NewTest() {
			System.out.println("test git");
		}
		
	
	@Test
	public void loginToZerodhaWithPinTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(password);
		zerodhaLoginPage.enterPassword(userName);
		zerodhaLoginPage.clickOnLogin();
		//Thread.sleep(5000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin =  Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin, driver);
		zerodhaPinPage.clickOnSubmit();
		
	}
	@Test//(priority=1)
	public void clickOnForgot2FATest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		//Thread.sleep(5000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);	
		zerodhaPinPage.clickOnForgot();
	}
	@Test(priority=1)
	public void clickOnDontHaveAnAccountSignupNowTest() throws EncryptedDocumentException, IOException, InterruptedException{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);	
		zerodhaPinPage.clickOnSignUp();
	}
}
