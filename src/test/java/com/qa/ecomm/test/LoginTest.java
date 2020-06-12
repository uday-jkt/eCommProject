package com.qa.ecomm.test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.qa.utils.CommonUtility;

public class LoginTest {
	
	public static WebDriver driver;

	@Test
	public void login() {

		URL url = null;
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		//options.addArguments("window-size=1200x600");
		
		if (CommonUtility.isWindows()) {

			url = LoginTest.class.getClassLoader().getResource("chromedriver.exe");

			File file = new File(url.getFile());
			
			ChromeDriverService.Builder bldr = (new ChromeDriverService.Builder()).usingDriverExecutable(file)
					.usingAnyFreePort();
			driver = new ChromeDriver(bldr.build());

		} else if (CommonUtility.isUnix()) {
			url = LoginTest.class.getClassLoader().getResource("chromedriver");
			File file = new File(url.getFile());
			ChromeDriverService.Builder bldr = (new ChromeDriverService.Builder()).usingDriverExecutable(file)
					.usingAnyFreePort();
			driver = new ChromeDriver(bldr.build());

		}
		

		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("uday.singh@testmail.com");
		driver.findElement(By.id("Password")).sendKeys("Tosca12345!");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		System.out.println(driver.getTitle());
        System.out.println("Testing Done !");
		driver.quit();
	}

}
