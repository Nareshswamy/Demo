//Author:KOPPARAPU VENKATA NARESH
package com.cognizant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultpage {
	private static WebElement el =null;
	
	 public static WebElement Flightnumber(WebDriver driver)
	 {
		 el = driver.findElement(By.xpath("//tr[@name='0_0_0_0']/td/span/a/span"));
		 return el;
	 }
}
