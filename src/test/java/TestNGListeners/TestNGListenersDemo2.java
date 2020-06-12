package TestNGListeners;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//added anotation in class level
//@Listeners(TestNGListeners.TestNGListenersFathi.class)
public class TestNGListenersDemo2 {

	@Test
	public void test4() {
		
		System.out.println("I'm inside test 4");
	}
	
	
	@Test
	public void test5() {
		
	System.out.println("I'm inside test 5");
	}
	
	
	@Test
	public void test6() {
		
		System.out.println("I'm inside test 6");
		//throw new SkipException("This test is Skipped");
	}
	
	
}
