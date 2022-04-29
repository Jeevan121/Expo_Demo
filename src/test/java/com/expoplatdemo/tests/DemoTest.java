package com.expoplatdemo.tests;

import org.junit.Test;
import org.openqa.selenium.By;

public class DemoTest {
	
	@org.testng.annotations.Test
	public void test() {
		
		
		
		
	}
	
	public By toDoLstRowChk(String data) {
		By toDoListRowsChk = By.xpath("(//label[text()='"+data+"'])[position()=1]");
		return toDoListRowsChk;
	}

}
