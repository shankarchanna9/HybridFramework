package com.hybrid.framework.Selenium.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent {

	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private static ExtentReports report;
	
	// getter
	public static ExtentTest getTest() {
		return extentTest.get();
	}

	// setter
	public static void setTest(ExtentTest test) {
		extentTest.set(test);
	}

	public static ExtentReports getInstance() {
		if (report == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "ExtentReport.html");
			report = new ExtentReports();
			spark.config().setDocumentTitle("Open Cart Application Test Summary");
			spark.config().setEncoding("utf-8");
			spark.config().setReportName("Automation Team");
			spark.config().setTheme(Theme.STANDARD);
			report.attachReporter(spark);
		}
		return report;
	}
	
}
