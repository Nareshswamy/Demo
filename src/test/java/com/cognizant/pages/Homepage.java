//Author:KOPPARAPU VENKATA NARESH

package com.cognizant.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	private static WebElement el =null;
	
	
	 public static WebElement RoundTrip(WebDriver driver) 
	 { 
		 el = driver.findElement(By.xpath("//input[@value='RoundTrip']"));
		 return el;
	 }
	  
	 
	 public static WebElement From(WebDriver driver)
	 {
		 el = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		  return el;
		
		 
	 }
	 public static WebElement To(WebDriver driver)
	 {
		 el = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		 return el;
	 }
	 public static void Date(WebDriver driver)
	 {
			 while (!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[1]")).getText().contains("March"))
		{
			driver.findElement(By.xpath("//a[@title='Next']/span")).click();
		}
		
		//for dates
		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='ui-state-default']"));
		int count = dates.size();
		for(int i=0; i<count;i++)
		{
			String text = dates.get(i).getText();
			if(text.equalsIgnoreCase("28"))
			{
				dates.get(i).click();
				break;
			}
			}
	 }
	 
	 public static WebElement Passenger(WebDriver driver)
	 {
		el = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		return el;
	 }
	 public static WebElement Searchbutton(WebDriver driver)
	 {
		el = driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights"));
		return el;
	 }
		 
	 

}
