package RahulshettyAcademy.Tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import RahulshettyAcademy.TestComponents.BaseTest;
import RahulshettyAcademy.pageobjects.OrderPage;
import RahulshettyAcademy.pageobjects.cartPage;
import RahulshettyAcademy.pageobjects.checkOutPage;
import RahulshettyAcademy.pageobjects.orderSuccPage;
import RahulshettyAcademy.pageobjects.productPage;


public class webTest extends BaseTest{
	
	String[] productNames= {"iphone 13 pro","zara coat 3"};
	List<String> productNamess=Arrays.asList(productNames);
	
	@Test (dataProvider ="getData" ,groups = {"purchaseHashMap"})
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		
		//String productName="iphone 13 pro";
		
		productPage productPg=loginPg.sendElements(input.get("email"),input.get("password"));
		cartPage cartpg=productPg.addtoCartclick(productNamess);
		Boolean matches=cartpg.CheckifCartMatches(productNamess);
		Assert.assertTrue(matches);
		checkOutPage cheoutpg=cartpg.clickOnCheckout();
		cheoutpg.selectCountry("India");
		orderSuccPage ordersucPg=cheoutpg.clickOnPlaceOrder();
		Assert.assertTrue(ordersucPg.getOrderMsg().equalsIgnoreCase("thankYOU FOR THE ORDER."));
	}
	
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void validateOrdProductNames() {
		
		productPage productPg=loginPg.sendElements("anil.ponugoti@gmail.com", "Authenticate123");
        OrderPage orderPg=productPg.ClickOnOrder();
        orderPg.validateOrdprodNames(productNamess);
	}
	
	
	@DataProvider
	public  Object[][] getData() {
		
		HashMap<String,String> map =new HashMap<String,String>();
		map.put("email", "anil.ponugoti@gmail.com");
		map.put("password", "Authenticate123");
		
		HashMap<Object,Object> map1 =new HashMap<Object,Object>();
		map1.put("email", "shetty@gmail.com");
		map1.put("password", "Iamking@000");
		
		
		return new Object[][] {{map},{map1}};
	}
	

}
