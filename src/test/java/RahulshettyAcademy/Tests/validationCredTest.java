package RahulshettyAcademy.Tests;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;
import RahulshettyAcademy.TestComponents.BaseTest;
import RahulshettyAcademy.TestComponents.Retry;
import RahulshettyAcademy.pageobjects.cartPage;
import RahulshettyAcademy.pageobjects.productPage;

public class validationCredTest extends BaseTest{
	@Test (groups = {"ValidateError"},retryAnalyzer = Retry.class)
	public void validateCredentials() {
		loginPg.sendElements("Anil.ponugoti@yahoo.com", "Authenticate123");
		String errorMessage=loginPg.getErrorMsg();
		System.out.println(errorMessage);
		Assert.assertEquals("Incorrect email r password.", errorMessage);
	}
	
	@Test 
	public void validateCartProducts() throws InterruptedException, IOException {
		
		//String productName="iphone 13 pro";
		String[] productNames= {"iphone 13 pro","zara coat 3"};
		List<String> productNamess=Arrays.asList(productNames);
		productPage productPg=loginPg.sendElements("anil.ponugoti@gmail.com", "Authenticate123");
		cartPage cartpg=productPg.addtoCartclick(productNamess);
		Boolean matches=cartpg.CheckifCartMatches(productNamess);
		Assert.assertTrue(matches);
		
		
		
		
	}
	
	
	

}
