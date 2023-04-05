package com.training;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	 String url,browser;
	
	@Before
	public void setup() throws IOException {
		url = "https://login.salesforce.com";
        System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get(url);
		driver.manage().window().maximize();
		
			  	
	}
	
	@Test
	public void validlogin() {
		String title = driver.getTitle();
		System.out.println("The page title is: "+title);
		Assert.assertEquals(title, "Login | Salesforce");
			
	}
	

	@After
	public void teardown() throws IOException {
	driver.quit();

	}

		
}
