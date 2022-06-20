package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import POM.Demo;
import POM.ZerodhaLoginPage;
import POM.ZerodhaPinPage;
import Utility.Parametrization;

public class DemoTest {

WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		driver = Browser.OpenBrowser();
	}
	@Test
	public void loginToZerodhaWithPinTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userName = Parametrization.getData(0, 1);
		String  password = Parametrization.getData(1, 1);
		zerodhaLoginPage.enterUserId(userName);
		zerodhaLoginPage.enterPassword(password);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		
		ZerodhaPinPage zerodhaPinPage=new ZerodhaPinPage(driver);
		String pin =  Parametrization.getData(2, 1);
		System.out.println(pin);
		zerodhaPinPage.enterPin(pin,driver);
		zerodhaPinPage.clickOnSubmit();
		Thread.sleep(2000);
		Demo demo = new Demo(driver);
	/*	String Stockname = "TATAMOTORS";
		zerodhaHomePage.enterStockName(Stockname);
		Thread.sleep(2000);
    	zerodhaHomePage.clickOnStockName();
	//	Actions action = new Actions (driver);
	//	WebElement Stock = driver.findElement(By.xpath("(//span[text()='TATAMOTORS'])[1]"));
	//	action.moveToElement(Stock) ;                
	//	action.perform();
		zerodhaHomePage.act(driver);
		Thread.sleep(2000);
		zerodhaHomePage.clickOnBuy();
	*/	
		String a = "TATAMOTORS";
		demo.getStock(a,driver);
		Thread.sleep(2000);
		demo.clickOnToggle();
		Thread.sleep(2000);
		demo.clickOnToggle();
		Thread.sleep(2000);
		demo.clickOnBSE();
		demo.ClickOnLongterm();
		
		//demo.clickOnIntraday();
		demo.clickOnQty();
	//	zerodhaHomePage.clickOnMarket();
	//	zerodhaHomePage.clickOnLimit();
		demo.clickOnLimit();
		
		//demo.clickOnSL();
		Thread.sleep(2000);
		demo.enterBuyPrice();
		Thread.sleep(2000);
		//demo.enterTriggerPrice();
		//Thread.sleep(2000);
		demo.clickOnbuy();
}

}

