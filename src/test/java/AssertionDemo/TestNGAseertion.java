package AssertionDemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class TestNGAseertion {

	
	@Test
	public void softAssertionTest() {
		
		SoftAssert assertion=new SoftAssert();
		System.out.println("Test 1 Started");
		assertion.assertEquals(12, 13);
		System.out.println("Test 1 Completed");
		assertion.assertAll(); //soft assert method call function
	}
	
	
	@Test
	public void hardAssertionTest() {
		
		System.out.println("Test 2 Started");
		Assert.assertEquals(12, 12);
		System.out.println("Test 2 Completed");
		
	}
	
	
}
