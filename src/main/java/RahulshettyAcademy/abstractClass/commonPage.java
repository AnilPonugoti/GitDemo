package RahulshettyAcademy.abstractClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulshettyAcademy.pageobjects.OrderPage;

public class commonPage {

	WebDriver driver;
	public commonPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy (css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement orders;
	
	
	
	public void ClickOnCart() {
		cart.click();
	}
	
	public OrderPage ClickOnOrder() {
		orders.click();
		OrderPage orderPg=new OrderPage(driver);
		return orderPg;
	}
	
	public void elementToBeVisible(WebElement elem) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elem));
		
	}
	
	public Select selectDropdowns(WebElement sel) {
		
		Select select=new Select(sel);
		return select;
	}
	
	
	

}
