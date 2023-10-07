package com.hybrid.framework.Selenium.common.ui.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.hybrid.framework.Selenium.accelerators.DriverFactory;
import com.hybrid.framework.Selenium.accelerators.PropertyFileReader;
import com.hybrid.framework.Selenium.reporting.Extent;

public interface WebActionElements {

	public final static int smallWait=Integer.valueOf(PropertyFileReader.getProperty("SMALL_WAIT"));
	public final static int mediumWait=Integer.valueOf(PropertyFileReader.getProperty("MEDIUM_WAIT"));
	public final static int largelWait=Integer.valueOf(PropertyFileReader.getProperty("LARGE_WAIT"));
	public final Logger LOGG = Logger.getLogger(WebActionElements.class);
	
	public default void extentPass(String message) {
		LOGG.info("-----------------------------------------------------------------------");
		LOGG.info(message);
		LOGG.info("-----------------------------------------------------------------------");
		Extent.getTest().pass(message);
	}
	public default void extentFail(String message) {
		LOGG.info("-----------------------------------------------------------------------");
		LOGG.warn(message);
		LOGG.info("-----------------------------------------------------------------------");
		Extent.getTest().fail(message);
	}
	public default void extentInfo(String message) {
		LOGG.info("-----------------------------------------------------------------------");
		LOGG.info(message);
		LOGG.info("-----------------------------------------------------------------------");
		Extent.getTest().info(message);
	}
	public default void extentSkip(String message) {
		Extent.getTest().skip(message);
	}
	public default void extentFail(String message,String screenshotName) {
		LOGG.info("-----------------------------------------------------------------------");
		LOGG.warn(message);
		LOGG.info("-----------------------------------------------------------------------");
		Extent.getTest().fail(message,MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());
	}
	public default String getScreenshot(String screenshotName) {
		try {
			TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			String filePath = "./ExtentReports/screenshots/" + screenshotName + ".png";
			FileUtils.copyFile(file, new File(filePath));
		} catch (IOException e) {
			System.out.println(e);
			LOGG.info(e);
		}
		String filePath2 = "./screenshots/" + screenshotName + ".png";
		return filePath2;
	}
	
	public default WebActionElements staticWait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds*1000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return this;
	}
	
	public default void smallWait() {
		try {
			LOGG.info("waiting");
			Thread.sleep(1000*smallWait);			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public default void mediumWait() {
		try {
			LOGG.info("waiting");
			Thread.sleep(1000*mediumWait);			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public default void largeWait() {
		try {
			LOGG.info("waiting");
			Thread.sleep(1000*largelWait);			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//frames
	//windows
	//click
	//sendtext
	//highlight
	//select dropdown
	//scroll
	//mouse over
	//navigate get url
	//getText
	//waits
	//actions class
	//alerts
	//dynamic dropdown
	//drag and drop
	//assertions
	//robot class methods
	//
	
	
}
