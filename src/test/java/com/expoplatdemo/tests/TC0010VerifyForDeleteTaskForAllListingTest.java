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

public class TC0010VerifyForDeleteTaskForAllListingTest extends BaseTest {
	

	ToDoListHomePage toDoListHomePage;
	
	@BeforeTest
	public void setUp() {
		
		launchApplication(AutoConfigs.url);
		toDoListHomePage=PageFactory.initElements(getDriver(), ToDoListHomePage.class);
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="AllListDelete",enabled=true,alwaysRun=true)
	public void tc0010VerifyForDeleteTaskForAllListingTest(String taskName) throws InterruptedException {
		
		// Adding/Creating  the new task
		toDoListHomePage.addTask(taskName);
		//Click on the All List Column
		getBasePage().safeClick(toDoListHomePage.allListBtn);
		//checked the list task to be deleted
		getBasePage().clickElemetsByJs(toDoListHomePage.toDoLstRowChk(taskName));
		//clicking on the remove button
		getBasePage().safeClick(toDoListHomePage.removeBtn);
		//then clicking on the delete all task button
		getBasePage().safeClick(toDoListHomePage.deleteAllTasksBtn);
		//confirm from the pop up
		getBasePage().safeClick(toDoListHomePage.popUpConfirmBtn);
		//validating the All List Columns list, it is deleted
		Assert.assertFalse(getBasePage().isElementPresent(toDoListHomePage.toDoLstRowChk(taskName)),"the task is not yet deleted");
		
	
	}
	
	@AfterTest
	public void quiteDriver() {
		getDriver().quit();
	}



}
