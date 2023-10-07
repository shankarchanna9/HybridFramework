package com.hybrid.framework.Selenium.accelerators;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public static final String gridURL="192.168.0.100";
 //	String driverLocalPath=System.getProperty("user.dir")+File.separator+PropertyFileReader.propertyFileReader(System.getProperty("user.dir")+File.separator).getProperty("DRIVER_PATH").trim();
	static String driverLocalPath=PropertyFileReader.getProperty("DRIVER_PATH");
	private BrowserFactory() {
		driver=null;
	}
	
	public static ChromeOptions getChromeOptions() {
		return null;
		
	}
	public static WebDriver createDriver(String browser) {
		browser=browser.toLowerCase();
		driver=null;
		//environment=environment.toLowerCase();
		
		switch(browser) {
		
		case "chromelocal":
			try {
				if (driver == null) {
					System.out.println(driverLocalPath);
					ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverLocalPath))
							.build();
					driver.set(new ChromeDriver(service));
				}
			} catch (Exception e) {
			}
			break;
		
		
		case "chromeremote":
			try {
				if (driver == null) {					
					driver.set(new RemoteWebDriver(new URL(gridURL),getChromeOptions()));
				}
			} catch (Exception e) {
			}
			break;
			
		default:
			break;
		}
		
		return driver.get();
	}
	
	public static WebDriver getDriver() {
		return createDriver("chromelocal");
		//return driver.get();
	}
	
	public static void tearDown() {
		System.out.println("Driver quit started");
		driver.get().quit();
		System.out.println("Driver quit finished");
	}
	
	public static void terminate() {
		driver.remove();
		System.out.println("Remove the ThreadLocalMap element");
	}
	                             
	}
	
