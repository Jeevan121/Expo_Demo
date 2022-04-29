package com.expoplatdemo.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.expoplatdemo.utils.ExcelUtils;






public class DataProviderUtils {
	
	@DataProvider(name = "CreateTask")
	  public static Object[][] createTask() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "CreateTask");
	    return objReturn;
	  }
	
	@DataProvider(name = "AllListDelete")
	  public static Object[][] allListDelete() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "AllListDelete");
	    return objReturn;
	  }
		
	
}
