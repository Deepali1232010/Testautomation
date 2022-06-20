package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJO.Browser;

public class Dataprovider {

WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.OpenBrowser();
	}
	
	@DataProvider(name = "NameData")
	public Object [][]data()
	{
	  return new Object[][]	{{"Velocity","Katraj"},{"Katraj","Pune"}};
	}


@Test(dataProvider="NameData")
public void GoToHomePageTest(String value,String pass) {
	{
		System.out.println(value + pass);
	}
}
}