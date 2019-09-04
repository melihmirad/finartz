package com.finartz.selenium.login.service;

import java.io.File;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeService {

	private static final String CHROME_PATH = "C:\\Users\\Asus N56VZ\\Desktop\\zips_jars_exe\\Exe Files\\chromedriver_win32\\chromedriver.exe";
	private ChromeDriverService service;
	private WebDriver driver;

	public void setup() {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(CHROME_PATH))
				.usingAnyFreePort()
				.build();
		try {
			service.start();
		} catch (Exception e) {
			System.out.println("Chrome service could not start!!! Reason: " + ExceptionUtils.getMessage(e));
		}

		System.setProperty("webdriver.chrome.driver", CHROME_PATH);
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
		driver.manage().window().maximize();
	}

	public void stop() {
		driver.quit();
		service.stop();
	}
	
	public void goToPage(String pageUrl) {
		driver.get(pageUrl);

	}
	
	public void enterInfoForLogin(String name, String value){
		driver.findElement(By.name(name)).sendKeys(value);;
	}
	
	public void clickButton() {
		driver.findElement(By.name("FormsButton2")).click();
	}

	public String getPageSource() {
		return driver.getPageSource().toString();
	}
	
	public boolean isAlertPresent() {
	    boolean presentFlag = false;

	    try {
	        Alert alert = driver.switchTo().alert();
	        presentFlag = true;
	        alert.accept();
	    } catch (NoAlertPresentException ex) {
	        ex.printStackTrace();
	    }

	    return presentFlag;
	}

}
