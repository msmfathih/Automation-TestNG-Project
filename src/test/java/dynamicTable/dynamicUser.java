package dynamicTable;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dynamicUser {

	public static void main(String[] args) throws InterruptedException {



		String projectLocation = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
  
		//dynamicUser.showEntries(driver);
		//dynamicUser.selectRAdioBtn(driver);
		
		dynamicUser.selectRAdioBtn(driver);
		//dynamicUser.searchName(driver);
	

	}
	



//selecting dynamically changing employee
	public static void selectRAdioBtn(WebDriver driver) {

		//selecting dynamic user checkbox
		String before_xpath="//*[@id=\"example\"]/tbody/tr[";
		String after_xpath="]/td[2]";


		for(int i=1; i<=10; i++) {

			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(name);
					

		if(name.contains("Cedric Kelly")) {
											 
				driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr["+i+"]/td[1]")).click();
				
				System.out.println("Employee, Brielle Williamson has been selected");
			}

		}

	} 
	

	
	public static void searchName(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[2]")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input")).sendKeys("Fiona Green");
		
	}
	
	
	

}
