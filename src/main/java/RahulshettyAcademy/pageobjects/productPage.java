package RahulshettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.abstractClass.commonPage;

public class productPage extends commonPage{
	
	WebDriver driver;

	public productPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".card-body")
	List<WebElement> productDetails;
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By productNames=By.cssSelector("b");
	
	@FindBy (id="toast-container")
	WebElement addtoCartMsg;

	
	public cartPage addtoCartclick(List<String> productNamess) throws InterruptedException {
		
		for (String productName:productNamess) {
			WebElement getProd= productDetails.stream().filter(product->product.findElement(productNames).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
			if(getProd==null)
			{
				System.out.println(productName +" is not there in list of products" );
				break;
			}
			getProd.findElement(addToCart).click();
			Thread.sleep(2000);
			elementToBeVisible(addtoCartMsg);
			System.out.println(addtoCartMsg.getText());
			
			
		}
		
		ClickOnCart();
		return new cartPage(driver);
	}
	
	
 }
