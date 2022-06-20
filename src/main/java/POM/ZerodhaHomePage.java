package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaHomePage {              

	@FindBy(xpath="//input[@type='text']")private WebElement Textbox;
	@FindBy(xpath="(//span[text()='TATAMOTORS'])[1]")private WebElement Tatamotors;
	@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement Buy;
	@FindBy(xpath="//label[@class='su-switch-control']")private WebElement Toggle;
	@FindBy(xpath="(//label[@class='su-radio-label'])[1]")private WebElement BSE;
	@FindBy(xpath="//label[text()='Intraday ']")private WebElement intraday;
	@FindBy(xpath="(//input[@type='number'])[1]")private WebElement Qty;
	@FindBy(xpath="//label[text()='Market']")private WebElement market;
	@FindBy(xpath="//button[@type='submit']")private WebElement buy;
	@FindBy(xpath="//label[text()='Longterm ']")private WebElement longterm;
	@FindBy(xpath="//label[text()='Limit']")private WebElement limit;
	@FindBy(xpath="//input[@label='Price']")private WebElement price;
   public ZerodhaHomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   public void EnterStockName(String Stockname) {
	   Textbox.sendKeys(Stockname);
   }
   public void ClickOnBuy() {
	   Buy.click();
   }
   public void ClickOnStockName() {
	   Tatamotors.click();
   }
   public void ClickOnToggle() {
	   Toggle.click();
   }
   public void ClickOnBSE() {
	   BSE.click();
   }
   public void ClickOnIntraday() {
	   intraday.click();
}
   public void ClickOnQty() {
	   Qty.clear();
	   Qty.sendKeys("2");
}
   public void ClickOnMarket() {
	   market.click();
}
   public void ClickOnbuy() {
	   buy.click();
}
   public void ClickOnLongterm() {
	   longterm.click();
}
   public void ClickOnLimit() {
	   limit.click();
}
   public void ClickOnPrice() {
	   price.clear();
	   price.clear();
	   price.sendKeys("488");
}
}

