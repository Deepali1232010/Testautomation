package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignupNowPage {

	@FindBy(xpath = "//input[@name='mobile']")private WebElement mobno;
	@FindBy(xpath = "//button[@id='open_account_proceed_form']")private WebElement Continue;
	@FindBy(xpath = "//a[text()='Want to open an NRI account?']")private WebElement Nriaccount;
	
	public ZerodhaSignupNowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void MobileNumber(String mobileno) {
		mobno.sendKeys( mobileno);
	}
	
	public void ClickOnContinueButton() {
		Continue.click();
	}
	public void ClickOnNriAccountButton() {
		Nriaccount.click();
}
}