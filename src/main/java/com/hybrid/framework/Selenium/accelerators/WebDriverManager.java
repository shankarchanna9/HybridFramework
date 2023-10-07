package com.hybrid.framework.Selenium.accelerators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriverManager {

	public static void createDriver() {
		
		 io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
	}
}
