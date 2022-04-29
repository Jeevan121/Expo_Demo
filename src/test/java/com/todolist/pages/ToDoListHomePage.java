package com.todolist.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.expoplatdemo.utils.BasePage;

public class ToDoListHomePage extends BasePage{
	
    private WebDriver driver;
	
	public ToDoListHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public By addTaskTxt = By.xpath("//input[contains(@id,'Typetask-AddTask')]");
	
	public By disabledCreateBtn = By.xpath("//button[@tabindex='-1']");
	
	public By enabledCreateBtn = By.xpath("//span[text()='Create']/parent::*/parent::*/parent::button");
	
	public By toDoListBtn = By.xpath("//div[text()='To Do']/parent::*/parent::*/parent::button");
	
	public By doneListBtn = By.xpath("//div[text()='Done']/parent::*/parent::*/parent::button");
	
	public By allListBtn = By.xpath("//div[text()='All']/parent::*/parent::*/parent::button");
	
	public By removeBtn = By.xpath("//div[@class='enable-remove-mode']//button");
	
	public By toDoLstRowChk(String data) {
		By toDoListRowsChk = By.xpath("(//label[text()='"+data+"'])[position()=1]");
		return toDoListRowsChk;
	}
		
	public By toDoListRow(String data) {
		By toDoListRow = By.xpath("(//label[text()='"+data+"'])[position()=1]");
		return toDoListRow;
	}
	
	public By toDoListColumnCount = By.xpath("//div[text()='To Do' and text()='1']");
	
	public By allListColumnCount = By.xpath("//div[text()='All']");
	
	public By deleteAllTasksBtn = By.xpath("//span[text()='Delete All Tasks']/parent::*/parent::*/parent::button");
	
	public By popUpConfirmBtn = By.xpath("//span[text()='Confirm']/parent::*/parent::button");
	
	
	public ToDoListHomePage addTask(String data) throws InterruptedException {
		Thread.sleep(1000);
		safeType(addTaskTxt, data);
		safeClick(enabledCreateBtn);
		return this;
	}
	
	
	
}
