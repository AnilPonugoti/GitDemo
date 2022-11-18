package RahulshettyAcademy.pageobjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulshettyAcademy.abstractClass.commonPage;

public class OrderPage extends commonPage{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="tr td:nth-child(3)")
	List<WebElement> ordProdNames;
	Boolean match;
	List<String> allProductNames = new ArrayList<>();
	public Boolean validateOrdprodNames(List<String> productNamess) {
		for (String Productname:productNamess)
		{
			match=ordProdNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(Productname));
			System.out.println(match);
		}
		
		for (String productNames:productNamess) {
			ordProdNames.stream().forEach(product -> allProductNames.add(product.getText()));
			
			// Print count of product found
			System.out.println("Total product found : "+allProductNames.size());
			
			// Printing product names
			System.out.println("All product names are : ");
			allProductNames.forEach(name -> System.out.println(name));
		}
		
		return match;
	}
	

	

}
