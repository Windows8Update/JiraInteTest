package com.amazon.testpage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	WebDriver driver;
	
	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public static void screencapture(WebDriver driver, String fname) throws IOException {
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(source, new File(fname));

		  // FileUtils.copyFile(source, new File("./Screenshots/HomePage.png"));

		 }

	
}
