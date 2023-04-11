package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	static {
		System.setProperty("driver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		Reporter.log("openBrowser",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("closeBrowser",true);
		driver.quit();
	}
	
	@BeforeMethod
	public void Login() throws IOException
	{
		Reporter.log("Login", true);
		FileLib f=new FileLib();
		String url = f.getpropertyData("url");
		driver.get(url);
		String un = f.getpropertyData("username");
		driver.findElement(By.id("username")).sendKeys(un);
		String pw = f.getpropertyData("password");
		driver.findElement(By.name("pwd")).sendKeys(pw);
		System.out.println(pw);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();	
	}
	
	@AfterMethod
	public void Logout()
	{
		Reporter.log("Logout", true);
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
	}

}
