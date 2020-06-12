package MultiBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestNGMultiBrowserTest {

	WebDriver driver = null;

	String projectLocation = System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	
	public void setUp(String browserName) {

		System.out.println("Browser name is :"+browserName);


		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", projectLocation+"\\Lib\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\Firefox.exe");	
			driver=new FirefoxDriver();


		}
	}

	@Test
	public void fillFormTest() throws InterruptedException {

		driver.get("http://demo.automationtesting.in/Register.html");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("mohamed");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("ijaz");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("This is a text message");

		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("admin@gmail.com");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("0528542762");

		//Verify page title method 1
		String title=driver.getTitle();
		System.out.println("This page title is: "+title);
		Assert.assertEquals(title, "Register");



	}


	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
