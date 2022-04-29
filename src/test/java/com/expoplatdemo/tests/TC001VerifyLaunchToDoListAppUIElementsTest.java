package com.expoplatdemo.tests;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.expoplatdemo.autoconstants.AutoConfigs;
import com.expoplatdemo.utils.BaseTest;
import com.todolist.pages.ToDoListHomePage;

/*
 * Author: Jeevan
 * TC Description : TC001 : To Verify for Launching the  To Do List App and Verifying for UI Elements Display 
 */

public class TC001VerifyLaunchToDoListAppUIElementsTest extends BaseTest{
	
	ToDoListHomePage toDoListHomePage;
	
	@BeforeTest
	public void setUp() {
		
		launchApplication(AutoConfigs.url);
		toDoListHomePage=PageFactory.initElements(getDriver(), ToDoListHomePage.class);
	}
	
	@Test
	public void tc001VerifyLaunchToDoListAppUIElementsTest() throws InterruptedException {
		
		//Validating the Add Task Text Box is present in the Home Page or not
		Boolean addTaskTxt = getBasePage().isElementPresent(toDoListHomePage.addTaskTxt);
		Assert.assertTrue(addTaskTxt, "The Element is not present in the Screen");
		
		
		//Validating the disabled Create Button is present in the Home Page or not
		Boolean disablecreateBtn = getBasePage().isElementPresent(toDoListHomePage.disabledCreateBtn);
		Assert.assertTrue(disablecreateBtn, "The Element is not present in the Screen");
		
		
		//Validating the ToDoList Button is present in the Home Page or not
		Boolean toDoListBtn = getBasePage().isElementPresent(toDoListHomePage.toDoListBtn);
		Assert.assertTrue(toDoListBtn, "The Element is not present in the Screen");
		
		//Validating the done List Button is present in the Home Page or not
		Boolean doneListBtn = getBasePage().isElementPresent(toDoListHomePage.doneListBtn);
		Assert.assertTrue(doneListBtn, "The Element is not present in the Screen");
		
		
		//Validating the All List Button is present in the Home Page or not
		Boolean allListBtn = getBasePage().isElementPresent(toDoListHomePage.allListBtn);
		Assert.assertTrue(allListBtn, "The Element is not present in the Screen");
		
		//Validating the remove Button is present in the Home Page or not
		Boolean removeBtn = getBasePage().isElementPresent(toDoListHomePage.removeBtn);
		Assert.assertTrue(removeBtn, "The Element is not present in the Screen");
			
	}
	
	@AfterTest
	public void quiteDriver() {
		getDriver().quit();
	}
	

}
