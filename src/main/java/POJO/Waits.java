package POJO;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
         
	WebDriver driver;
	
	public Waits(int a,WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(a));//Explicit wait
		wait.until(ExpectedConditions.visibilityOf(Element));//will recheck the element in 500ms
		//pin.sendKeys();
	}
}
