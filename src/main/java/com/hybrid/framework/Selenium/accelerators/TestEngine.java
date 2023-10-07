package com.hybrid.framework.Selenium.accelerators;

import java.time.Duration;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestEngine {
	static String browserName="chromelocal";

	@BeforeSuite
	public void beforeSuite() {
		DriverFactory.createDriver(browserName);			
	}
	@BeforeTest
	public void beforeTest() {
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertyFileReader.getProperty("LARGE_WAIT"))));
		DriverFactory.getDriver().manage().deleteAllCookies();
		DriverFactory.getDriver().get(PropertyFileReader.getProperty("URL"));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	@AfterTest
	public void afterTest() {
		DriverFactory.tearDown();	
	}
	@AfterSuite
	public void afterSuite() {
		DriverFactory.terminate();		
	}
}
