//Author:KOPPARAPU VENKATA NARESH
package com.cognizant.libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.cognizant.pages.Homepage;
import com.cognizant.pages.SearchResultpage;
import com.cognizant.utilities.Excelsheet;
import com.cognizant.utilities.Screenshot;
public class TestMethods extends Excelsheet {

	 public WebDriver driver;
	FileInputStream f = null;
	Properties prop = null;
	public WebDriver selectBrowser() throws IOException 
	{
		f = new FileInputStream("URL.properties");
		prop = new Properties();
		prop.load(f);
		
		if(prop.getProperty("driver").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("driver").equals("firefox"))
		{
			System.setProperty("WebDriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}

	public void InvokingBrowser() throws IOException 
	{
		prop.load(f);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	public void HomePage() throws IOException, InterruptedException {
		Thread.sleep(5000);
		Homepage.RoundTrip(driver).click();
		Homepage.From(driver).click();
		String[][] data = new String[1][2]; 
		data = Excelsheet.data();
		Homepage.From(driver).sendKeys(data[0][0]); 
		Thread.sleep(5000); 
		Homepage.To(driver).sendKeys(data[0][1]);
		Homepage.Date(driver);
		Homepage.Passenger(driver).click();
		Select adult = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']")));
		adult.selectByValue("2");
		
		Homepage.Searchbutton(driver).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void FlightAvailability() throws InterruptedException, InvalidFormatException, IOException {
		
		String Flightnumber = SearchResultpage.Flightnumber(driver).getText();
		System.out.println("The first flight number is  " + Flightnumber);
		Screenshot.takeScreenshot(1, driver);
	}

}
