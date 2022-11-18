package RahulshettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.abstractClass.commonPage;

public class loginPage extends commonPage{
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (id="userEmail")
	private WebElement email;
	
	@FindBy (id="userPassword")
	private WebElement password;
	
	@FindBy (id="login")
	private WebElement login;
	
	@FindBy (css="[class*='flyInOut']")
	private WebElement ErrorMsg;
	
	
	public productPage sendElements(String username, String Password) {
		email.sendKeys(username);
		password.sendKeys(Password);
		login.click();
		return new productPage(driver);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg() {
		elementToBeVisible(ErrorMsg);
		return ErrorMsg.getText();
		
	}
}
