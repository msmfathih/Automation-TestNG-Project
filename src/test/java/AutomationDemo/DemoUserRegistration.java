package AutomationDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoUserRegistration {

	WebDriver driver;

	@BeforeTest()
	public void setUpTest() {

		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.manage().window().maximize(); //maximize browser

		driver.get("http://demo.automationtesting.in/Register.html");

	}


	@Test(priority=1)
	public void fillFormTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("mohamed");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("ijaz");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("This is a text message");

		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("admin@gmail.com");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("0528542762");

		//Verify page title method 1
		String title=driver.getTitle();
		System.out.println("This page title is: "+title);
		Assert.assertEquals(title, "Register");

	}



	@Test(priority=2)
	public void chooseUploadFileTest() throws InterruptedException { 

		String filePath="C:\\Users\\fathih\\eclipse-workspace\\RentVehicals\\images\\licenece copy.jpeg";

		WebElement uploadButton=driver.findElement(By.id("imagesrc"));
		uploadButton.sendKeys(filePath);
		Thread.sleep(1500);

	}

	@Test(priority=3)
	public void select_RadioBtn_GenderTest() {

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();

		if(driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).isSelected()==true) {

			System.out.println("Gender male is selected");
		}

	}


	@Test(priority=4)
	public void select_CheckBoxes_hobby() {

		driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();


		// and condition is true , when all are true, if not false 
		if(driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).isSelected()==true &&  driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).isSelected()==true){

			System.out.println("Hockey and  movie  hobby selected");
		}

		// if any of them is true, whole statement become true doest chk 2nd statement

		if(driver.findElement(By.xpath("//*[@id=\"checkbox3\"]")).isSelected()==true || driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).isSelected()==true){

			System.out.println("Hockey or   movie  hobby selected");
		}



	}


	@Test(priority=5)	
	public void select_Language_Dropdown_Test() {

		driver.findElement(By.id("msdd")).click();

		List<WebElement> list=(List<WebElement>) driver.findElements(By.xpath("//ul[contains(@class,'ui-corner-all')]//li//a"));

		System.out.println(list.size());

		//select only one language 
		for(int i=0; i<list.size(); i++){

			System.out.println(list.get(i).getText());  //print all elements

			if(list.get(i).getText().contains("English")) {

				list.get(i).click();

				driver.findElement(By.xpath("//*[@id=\"section\"]/div/div")).click();
				break;
			}

		}
	}



	@Test(priority=6)
	public void select_DateofBirth_DropdownTest() throws InterruptedException {

		driver.findElement(By.id("yearbox")).click();Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"yearbox\"]/option[77]")).click();

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select/option[12]")).click();

		driver.findElement(By.id("daybox")).click();Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"daybox\"]/option[15]")).click();

		driver.findElement(By.id("firstpassword")).sendKeys("12345");
		driver.findElement(By.id("secondpassword")).sendKeys("35235");

		driver.findElement(By.id("submitbtn")).click();


	}



	@Test(priority=7)
	public void mouseHover_Alertmethod_Test() throws InterruptedException {

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


	}


	@AfterTest(enabled=false)
	public void tearDownTest() {

		driver.close();
		System.out.println("Test Completed Successfully");
	}

}
