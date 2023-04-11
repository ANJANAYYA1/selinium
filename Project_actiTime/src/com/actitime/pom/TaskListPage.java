package com.actitime.pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.FileLib;

public class TaskListPage {
	FileLib f=new FileLib();
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[@class='item createNewCustomer']")
	private WebElement createNewCustomerBtn;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Name' and @class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement enterCustomerName;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustomerDescription;
	
	@FindBy(xpath="(//div[text()='- Select Customer -'])[1]")
	private WebElement selectCustomer;
	
	@FindBy(xpath="(//div[text()='Anvesh'])[13]")
	private WebElement ourCompany;
	
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement CreateCustomer;
	
	
	
	public TaskListPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public void setAddNew()
	{
		addNewBtn.click();
	}
	
	public void setCreateName()
	{
		createNewCustomerBtn.click();
	}
	
	
	public void setCustomerName() throws IOException
	{
		String data = f.getExcelData("CreateCustomer", 1, 2);
		enterCustomerName.sendKeys(data);
	}
	
	public void setCustomerDescription() throws IOException
	{
		String data = f.getExcelData("CreateCustomer", 1, 3);
		enterCustomerDescription.sendKeys(data);
	}

	public void setSelectCustomer()
	{
		selectCustomer.click();
	}

	public void setCompany()
	{
		ourCompany.click();
	}

	public void setCreateCustomer()
	{
		CreateCustomer.click();
	}
}
