package TestNGListeners;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;


//can add multiple listeners
public class TestNGListenersFathi implements ITestListener, ISuiteListener {
	
	
	
	public void onTestStart(ITestContext result) {
		System.out.println("*******Test Started: "+result.getName());
		
	}
	
	public void onTestSuccess(ITestContext result) {
		System.out.println("*******Test is Successful: "+result.getName());
		
	}

	
	public void onTestFailure(ITestContext result) {
		System.out.println("*******Test is Failed: "+result.getName());
	}
	
	
	public void onTestSkipped(ITestContext result) {
		System.out.println("*******Test Skipped: "+result.getName());
		
	}

	
	public void onFinish(ITestContext result) {
		System.out.println("*******Test Skipped: "+result.getName());
		
	}
	
	
	public void onStart(ITestContext result) {
		System.out.println("*******Test Completed: "+result.getName());
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestContext result) {
		
		
	}

	




}
