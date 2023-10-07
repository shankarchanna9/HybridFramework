package com.hybrid.framework.Selenium.accelerators;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	static String driverLocalPath=PropertyFileReader.getProperty("DRIVER_PATH");
	static String gridURL="http://192.168.0.100";	

	public static void createDriver(String browserName) {
		browserName = browserName.toLowerCase();

		switch (browserName) {
		case "chromelocal":
			ChromeDriverService service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(driverLocalPath)).build();
			driver.set(new ChromeDriver(service));

			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverLocalPath);
			driver.set(new FirefoxDriver());

			break;

		case "chromeremote":
			//System.setProperty("webdriver.gecko.driver", driverLocalPath);

			try {
				driver.set(new RemoteWebDriver(new URL(gridURL), null));
			} catch (Exception e) {
				System.err.println(e);
			}

			break;
		}

	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	
	public static void tearDown() {
		System.out.println("Driver quit started");
		driver.get().quit();
		System.out.println("Driver quit finished");
	}
	
	public static void terminate() {
		driver.remove();
		System.out.println("Removed the ThreadLocalMap element");
	}
	
	
	
}
