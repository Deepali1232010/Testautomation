package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import POM.ZerodhaHomePage;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;
import Utility.Report;
@Listeners(TestListeners.class)
public class HomePageTest extends BaseTest {
 
	ExtentReports reports;
	ExtentTest test;
//WebDriver driver;
	
	@BeforeTest
	public void extentReport() {
		reports =Report.CreateReport();
		}
	@AfterMethod
	public void captureResult(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterTest
	public void flushResult() {
		reports.flush();
		
	}
	
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser();
	}
	
	
	@Test //(priority=-1)
	public void loginToZerodhaWithPinTest() throws EncryptedDocumentException, IOException, InterruptedException {
	test =	reports.createTest("loginToZerodhaWithPinTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
	
		zerodhaLoginPage.enterUserId(userName);
		Thread.sleep(2000);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(5000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin =  Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin, driver);
		zerodhaPinPage.clickOnSubmit();
		Thread.sleep(3000);
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		String Stockname = "TATAMOTORS";
		zerodhaHomePage.EnterStockName(Stockname);
		Thread.sleep(3000);
		//zerodhaHomePage.ClickOnStockName();
		Actions action = new Actions (driver);
		WebElement Stock = driver.findElement(By.xpath("(//span[text()='TATAMOTORS'])[1]"));
		action.moveToElement(Stock) ;                
		action.perform();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnBuy();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnToggle();
		Thread.sleep(2000);
		zerodhaHomePage.ClickOnToggle();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnBSE();
		zerodhaHomePage.ClickOnIntraday();
		zerodhaHomePage.ClickOnQty();
		zerodhaHomePage.ClickOnMarket();
		zerodhaHomePage.ClickOnbuy();
		
}
	
	
	

	@Test
	public void StockBuyWithLongtermTest() throws EncryptedDocumentException, IOException, InterruptedException {
		test =	reports.createTest("StockBuyWithLongtermTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		Thread.sleep(2000);
		zerodhaLoginPage.enterPassword(password);
		Thread.sleep(2000);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin =  Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin, driver);
		zerodhaPinPage.clickOnSubmit();
		Thread.sleep(3000);
		
		
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		String Stockname = "TATAMOTORS";
		zerodhaHomePage.EnterStockName(Stockname);
		Thread.sleep(3000);
		//zerodhaHomePage.ClickOnStockName();
		Actions action = new Actions (driver);
		WebElement Stock = driver.findElement(By.xpath("(//span[text()='TATAMOTORS'])[1]"));
		action.moveToElement(Stock) ;                
		action.perform();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnBuy();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnToggle();
		Thread.sleep(2000);
		zerodhaHomePage.ClickOnToggle();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnBSE();
		zerodhaHomePage.ClickOnLongterm();
		zerodhaHomePage.ClickOnQty();
		zerodhaHomePage.ClickOnLimit();
		Thread.sleep(3000);
		zerodhaHomePage.ClickOnPrice();
		
		zerodhaHomePage.ClickOnBuy() ;
}
}