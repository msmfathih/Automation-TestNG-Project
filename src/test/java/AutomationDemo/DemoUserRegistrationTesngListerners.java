package AutomationDemo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoUserRegistrationTesngListerners implements ITestListener {

	WebDriver driver;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;


	@BeforeSuite
	public void setUpTest() {



		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); 
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.manage().window().maximize(); //maximize browserr

	}
 

	@Test(priority=1, testName="Sample test")
	public void fillFormTest() throws InterruptedException, IOException {


		ExtentTest test = extent.createTest("fillFormTest", "Fill the required details");

		driver.get("http://demo.automationtesting.in/Register.html");
		test.pass("Navigated demo automationtesting site");

 
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
		
		
		/*-------------------------------------Extent methods----------------------------------------------------------------*/

		
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("mohamed");
		test.pass("First name entered successfully.");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("ijaz");
		test.pass("Last name entered successfully.");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("This is a text message");
		test.pass("Address entered successfully.");

		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("admin@gmail.com");
		test.pass("Email entered successfully.");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("0528542762");
		test.pass("Phone number entered successfully.");

		//Verify page title method 1
		String title=driver.getTitle();
		System.out.println("This page title is: "+title);
		Assert.assertEquals(title, "Register");
		test.pass("Page title verified successfully.");

	}


	@Test(priority=2)
	public void chooseUploadFileTest() throws InterruptedException { 

		ExtentTest test = extent.createTest("chooseUploadFileTest", "Uploading driving licence image");

		String filePath="C:\\Users\\fathih\\eclipse-workspace\\RentVehicals\\images\\licenece copy.jpeg";

		WebElement uploadButton=driver.findElement(By.id("imagesrc"));
		uploadButton.sendKeys(filePath);
		Thread.sleep(1500);
		test.pass("Image has been uploaded");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

	}



	@Test(priority=3)
	public void select_RadioBtn_GenderTest() {

		ExtentTest test = extent.createTest("select_RadioBtn_GenderTest", "Selecting Gender in the radio button");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();

		if(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).isSelected()==true) {
				
			System.out.println("Gender male is selected");

			test.pass("Gender male is selectedd");
		}

	}
	
	

	
	@Test(priority=4)
	public void select_CheckBoxes_hobby() {

		ExtentTest test = extent.createTest("select_CheckBoxes_hobby", "Selecting Hobbbies from the CheckBoxes");
		
		driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();


		// and condition is true , when all are true, if not false 
		if(driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).isSelected()==true &&  driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).isSelected()==true){

			System.out.println("Hockey and  movie  hobby selected");
		}

		// if any of them is true, whole statement become true doest chk 2nd statement

		if(driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).isSelected()==true || driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).isSelected()==true){

			System.out.println("Hockey or   movie  hobby selected");
			test.pass("Hobbies has been selected");
		}



	}






	@Test(priority=5)	
	public void select_Language_Dropdown_Test() {

		ExtentTest test = extent.createTest("select_Language_Dropdown_Test", "Select Preferred language from the dropdown menu ");

		driver.findElement(By.id("msdd")).click();

		List<WebElement> list=(List<WebElement>) driver.findElements(By.xpath("//ul[contains(@class,'ui-corner-all')]//li//a"));

		System.out.println(list.size());

		//select only one language 
		for(int i=0; i<list.size(); i++){

			System.out.println(list.get(i).getText());  //print all elements

			if(list.get(i).getText().contains("Arabic")) {

				list.get(i).click();

				driver.findElement(By.xpath("//*[@id=\"section\"]/div/div")).click();
				break;

			}

		}

		test.pass("Language EnglishSelected");
	}


	@Test(priority=6)
	public void select_DateofBirth_DropdownTest() throws InterruptedException {

		ExtentTest test = extent.createTest("select_DateofBirth_DropdownTest", "Select Date of Birth & Set Password");

		driver.findElement(By.id("yearbox")).click();Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"yearbox\"]/option[77]")).click();

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select/option[12]")).click();

		driver.findElement(By.id("daybox")).click();Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"daybox\"]/option[15]")).click();

		driver.findElement(By.id("firstpassword")).sendKeys("12345");
		driver.findElement(By.id("secondpassword")).sendKeys("35235");

		driver.findElement(By.id("submitbtn")).click();

		test.pass("Date of Birth and Password has been Set");


	}



	@Test(priority=7)
	public void mouseHover_Alertmethod_Test() throws InterruptedException {


		ExtentTest test = extent.createTest("mouseHover_Alertmethod_Test", "Navigate into ALert page and click & Capture text in the Alert");

		Actions action2=new Actions(driver);

		action2.moveToElement(driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a"))).build().perform();
		Thread.sleep(1500);

		driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[1]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();

		Thread.sleep(1500);
		//		Alert alt=driver.switchTo().alert();
		//		alt.accept();

		//capturing alert message
		String actual_msg=driver.switchTo().alert().getText();
		Thread.sleep(1500);
		System.out.println("Alert msg is "+actual_msg);

		driver.switchTo().alert().accept();

		test.pass("Clicked on alert button and Captured Alert text");
	}


	@AfterSuite
	public void tearDownTest() {

		extent.flush();
		driver.quit();
	}



}
