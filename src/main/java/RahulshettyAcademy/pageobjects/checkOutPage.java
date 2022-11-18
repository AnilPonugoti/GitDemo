package RahulshettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.abstractClass.commonPage;

public class checkOutPage extends commonPage{
	
	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css="[placeholder='Select Country']")
	WebElement Country;
	
	
	@FindBy (css=".ta-results")
	WebElement results;
	
	@FindBy (css=".ta-item:last-child")
	WebElement selectCountry;
	
	@FindBy (css=".action__submit")
	WebElement placeOrder;
	
	public void selectCountry(String countryName) {
		
		Actions action=new Actions(driver);
		action.sendKeys(Country,countryName).build().perform();
		elementToBeVisible(results);
		selectCountry.click();
		
	}
	
	public orderSuccPage clickOnPlaceOrder() {
		placeOrder.click();
		return new orderSuccPage(driver);
	}
	

}
