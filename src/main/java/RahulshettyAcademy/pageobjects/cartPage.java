package RahulshettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	WebDriver driver;

	public cartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy (css=".totalRow button")
	WebElement checkout;
	
	Boolean match;
	public Boolean CheckifCartMatches(List<String> productNamess){
		
		for (String ProdcutName:productNamess)
		{
			match=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(ProdcutName));
			
		}
		return match;
		
	}
	
	public checkOutPage clickOnCheckout() {
		checkout.click();
		return new checkOutPage(driver);
		
	}
	

}
