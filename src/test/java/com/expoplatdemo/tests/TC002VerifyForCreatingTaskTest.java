package com.expoplatdemo.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.expoplatdemo.autoconstants.AutoConfigs;
import com.expoplatdemo.dataprovider.DataProviderUtils;
import com.expoplatdemo.utils.BaseTest;
import com.todolist.pages.ToDoListHomePage;

/*
 * Author: Jeevan
 * TC Description : TC002 : To Verify for Creating Tasks/Add Task 
 */


public class TC002VerifyForCreatingTaskTest extends BaseTest{
	
ToDoListHomePage toDoListHomePage;
	
	@BeforeTest
	public void setUp() {
		
		launchApplication(AutoConfigs.url);
		toDoListHomePage=PageFactory.initElements(getDriver(), ToDoListHomePage.class);
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="CreateTask",enabled=true,alwaysRun=true)
	public void tc002VerifyForCreatingTaskTest(String taskName,String count) throws InterruptedException {
		//Adding the Task and then clicking on the to do list column
		toDoListHomePage.addTask(taskName);
		getBasePage().safeClick(toDoListHomePage.toDoListBtn);
		 
		//Validating just created to do list row data against the test input data
		String addedTaskText = getBasePage().getText(toDoListHomePage.toDoListRow("Testing 1")).toString().trim();
		Assert.assertEquals(addedTaskText,taskName,"the addes task is not created and listed in the to do list");
		
		//Validating the to do list column count, it is  1 because created 1 row of data
		String todoListColumnCount = getBasePage().getText(toDoListHomePage.toDoListColumnCount).toString().trim();
		int toDoListCount = getToDoListCount(todoListColumnCount);
		Assert.assertEquals(toDoListCount,Integer.parseInt(count),"the to do list column count is not matching");
		
		//Validating the All list column count, it is 1 because created 1 row of data
		String allListColumnCount = getBasePage().getText(toDoListHomePage.allListColumnCount).toString().trim();
		int allListCount = getAllListCount(allListColumnCount);
		Assert.assertEquals(allListCount,Integer.parseInt(count),"the to do list column count is not matching");
	
	}
	
	@AfterTest
	public void quiteDriver() {
		getDriver().quit();
	}

}
