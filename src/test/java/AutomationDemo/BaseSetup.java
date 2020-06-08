/**
 * 
 */
package AutomationDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author fathih
 *
 */
public class BaseSetup {
	
	WebDriver driver;
	
	@BeforeTest()
	public void setUpTest() {

		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.manage().window().maximize(); //maximize browser

		driver.get("http://demo.automationtesting.in/Register.html");

	}
	
	
	
	@AfterTest
	public void tearDownTest() {

				
				driver.close();
				System.out.println("Test Completed Successfully");
	}
	

}
