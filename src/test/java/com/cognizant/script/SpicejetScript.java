//Author:KOPPARAPU VENKATA NARESH
package com.cognizant.script;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.cognizant.libraries.TestMethods;


public class SpicejetScript extends TestMethods {
	WebDriver driver = null;
	TestMethods function = null;

	@BeforeSuite
	public void beforeTest() throws IOException {
		function = new TestMethods();
		driver = function.selectBrowser();
		
	}

	
	@Test(priority = 0)
	public void Invoke() throws IOException {
		function.InvokingBrowser();
	}
	@Test(priority = 1)
	public void EnteringDetails() throws IOException, InterruptedException {
		function.HomePage();
	}
	@Test(priority = 2)
		public void FirstFlight() throws InvalidFormatException, InterruptedException, IOException {
		function.FlightAvailability();
	}

	@AfterSuite
	public void afterTest() {
		driver.close();
	}

}
