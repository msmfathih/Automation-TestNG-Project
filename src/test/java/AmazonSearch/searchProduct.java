package AmazonSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class searchProduct {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {


		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); 
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize(); 

	


//				searchProduct.searchLaptop(driver);
//				searchProduct.priceRange(driver);
				
		searchProduct.googleSearch(driver);

	} 



	@Test
	public static void googleSearch(WebDriver driver) throws InterruptedException {


		driver.get("https://www.google.com/"); 
		
		driver.navigate().refresh();
		//driver.navigate().back();

		driver.findElement(By.xpath("//*[@id=\"SIvCob\"]/a[2]")).click();
		Thread.sleep(1500);

		driver.findElement(By.name("q")).sendKeys("schools in dubai");

		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));


		System.out.println("Total number of suggetions===>" + list.size());


		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());

			if(list.get(i).getText().contains("schools in dubai fees")) {
				list.get(i).click();
				break;
			}
		}


	}




	public static void searchLaptop(WebDriver driver) throws InterruptedException {
		
		driver.get("https://www.amazon.ae/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mac book pro 16 inch");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("mac book pro");

		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		//		radioBtn.click();
		//		System.out.println("TApped on saerch btn "+radioBtn.isSelected());

		//16gb ram
		WebElement ramCheckbox = driver.findElement(By.xpath("//*[@id=\"p_n_feature_sixteen_browse-bin/15314783031\"]/span/a/div/label/i"));
		ramCheckbox.click();

		//500 to 999 GB
		WebElement hardDrive = driver.findElement(By.xpath("//*[@id=\"p_n_feature_eighteen_browse-bin/12064997031\"]/span/a/div/label/i"));
		hardDrive.click();



	}


	public static void priceRange(WebDriver driver) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("low-price")).sendKeys("5000");

		driver.findElement(By.name("high-price")).sendKeys("1000");

		driver.findElement(By.xpath("//*[@id=\"a-autoid-1\"]/span/input")).click();

		//driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/h2/a")).click();


	}




}
