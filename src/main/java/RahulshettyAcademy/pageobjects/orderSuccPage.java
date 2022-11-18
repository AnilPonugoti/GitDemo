package RahulshettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.abstractClass.commonPage;

public class orderSuccPage extends commonPage{

	WebDriver driver;
	public orderSuccPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (css=".hero-primary")
	WebElement OrderMsg;
	
	public String getOrderMsg() {
		System.out.println(OrderMsg.getText());
		return OrderMsg.getText();
	}

}
