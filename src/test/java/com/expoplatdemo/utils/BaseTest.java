package com.expoplatdemo.utils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	WebDriver driver;
	
	BasePage basePage;

	public void launchApplication(String url) {
		
		driver = new CreateBrowserInstance().launchBrowser(url);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	 public BasePage getBasePage() {
		    if (basePage == null) {
		      basePage = new BasePage(getDriver());
		    }
		    return basePage;
		  }
	 
	 public static void captureScreenshot(WebDriver driver, String screenshotname) {
		    try {
		      final String timestamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
		      final String timeStamp1 = (timestamp.replaceAll("/", "_")).replaceAll(":", "_").replace(" ", "_");
		      final TakesScreenshot screenshot = (TakesScreenshot) driver;
		      final File source = screenshot.getScreenshotAs(OutputType.FILE);
		      FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + timeStamp1 + ".png"));
		      System.out.println("Screenshot Taken");
		    } catch (final Exception excep) {
		      System.out.println("Throwing exception while taking screenshot" + excep.getMessage());
		    }
	 }
	 
	 public int getToDoListCount(String data) {
		String toDoListCount = data.split(" ")[2];
		String toDoCnt = (String) toDoListCount.subSequence(1,2);
		return Integer.parseInt(toDoCnt);
	 }
	 
	 public int getAllListCount(String data) {
		 	String allListCount = data.split(" ")[1];
			String allCnt = (String) allListCount.subSequence(1,2);
			return Integer.parseInt(allCnt);
		 }
}
