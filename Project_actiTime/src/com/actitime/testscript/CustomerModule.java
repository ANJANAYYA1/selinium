package com.actitime.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenersImplementation.class)
public class CustomerModule extends BaseClass {
		
	@Test
	public void testCreateCustomer() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage h=new HomePage(driver);
		h.setTaskbtn();
		
		TaskListPage t=new TaskListPage(driver);
		t.setAddNew();
		t.setCreateName();
		t.setCustomerName();
		t.setCustomerDescription();
		t.setSelectCustomer();
		t.setCompany();
		t.setCreateCustomer();
		
		boolean k = driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']/div[@class='title']")).isDisplayed();
		if(k==true)
		{
			System.out.println("hii");
			System.out.println("done");
		}
		else
		{
			System.out.println("not done");
		}
		
	}
	
}
