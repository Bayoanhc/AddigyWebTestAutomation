package com.addigy.automation.AddigyAutomation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AddigyTestLogIn {
	
	private static WebDriver driver;
	//private static ChromeDriverService service;
	
	private String url = "https://dev.addigy.com/login";
	private String email = "negata1898@jmail7.com";
	private String password = "1234567890";


	@Before
	public void setUp() {
		
		try {
			Process process = new ProcessBuilder("./src/test/resources/chromedriver/chromedriver.exe").start();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLogIn() throws InterruptedException {
		
		driver.get(url);
		Thread.sleep(2000);  // Let the user actually see something!
		
		WebElement emailBox = driver.findElement(By.id("username"));
		emailBox.sendKeys(email);
		
		WebElement passwordBox = driver.findElement(By.id("password"));
		passwordBox.sendKeys(password);
		Thread.sleep(2000);
		
		WebElement logInBtn = driver.findElement(By.id("addigySigninButton"));
		logInBtn.click();
		Thread.sleep(2000);
	
	}
	
	@After
	public void quitDriver() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
