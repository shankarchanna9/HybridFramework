package com.hybrid.framework.Selenium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.hybrid.framework.Selenium.Utilities.BasicUtility;
import com.hybrid.framework.Selenium.accelerators.DriverFactory;
import com.hybrid.framework.Selenium.accelerators.PropertyFileReader;
import com.hybrid.framework.Selenium.excelUtils.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTest implements BasicUtility {

	@Test
	public void sampleTest() {
//		System.out.println("Hello");
//		
//		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
//		DriverFactory.createDriver("chromelocal");
//		WebDriver driver=DriverFactory.getDriver();	
		//System.out.println(driver.getTitle());
		
		//ArrayList<Integer>
	//	ArrayList<Hashtable<String, String>> data12=ExcelUtils.getRowTestdata("LoginPage","LoginPageCases",0);
		//key + value
//		for(Map.Entry entry:data.entrySet()) {
//			System.out.println(entry.getKey() + "  |  "+ entry.getValue());
//		}
//		for (int i = 0; i < data12.size(); i++) {
//			Hashtable<String, String> data = data12.get(i);
//			
//			
//			System.out.println(data.get("TC_NAME"));
//			for (Map.Entry entry : data.entrySet()) {
//				System.out.println(entry.getKey() + "  |  " + entry.getValue());
//			}
//		}
		
	}


}
