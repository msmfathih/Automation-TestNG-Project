package TestNGListeners;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//added anotation in class level
//@Listeners(TestNGListeners.TestNGListenersFathi.class)
public class TestNGListenersDemo {

	@Test
	public void test1() {
		
		System.out.println("I'm inside test 1");
	}
	
	
	@Test
	public void test2() {
		
		System.out.println("I'm inside test 2");
		//Assert.assertTrue(false);
	}
	
	
	@Test
	public void test3() {
		
		System.out.println("I'm inside test 3");
		//throw new SkipException("This test is Skipped");
	}
	
	
}
