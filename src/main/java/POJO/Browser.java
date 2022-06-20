package POJO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver OpenBrowser() {// here webdriver is return tye
		ChromeOptions options = new ChromeOptions();//class of Selenium
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","D:\\Selineum\\chromedriver.exe" );
		WebDriver driver = new  ChromeDriver(options);//Webdriver ki sari method driver is variable main save ki hain
		driver.get("https://kite.zerodha.com/");// method of webdriver interface
		
		driver.manage().window().maximize();
		
	//	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);//Implicit wait
		return driver;
	}

}
