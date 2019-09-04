package com.finartz.selenium.login.service;

import java.util.logging.Logger;

public class LoginService {
	final static Logger LOG = Logger.getLogger(LoginService.class.getName());
	private final String EXPECTED = "Successful Login";
	private ChromeService chromeService;
	
	public LoginService(ChromeService chromeService)
	{
		this.chromeService = chromeService;
	}
	
	public void login(String userName, String password) {
		chromeService.goToPage("http://thedemosite.co.uk/login.php");
		LOG.info("Login page has open...");
		
		chromeService.enterInfoForLogin("username", userName);
		LOG.info("Username has been got... Username: " + userName);
		
		chromeService.enterInfoForLogin("password", password);
		LOG.info("Password has been got...");
		
		chromeService.clickButton();
	}

	public boolean isLoginSuccessful() {
		String pageSource = chromeService.getPageSource();
		if (pageSource.contains(EXPECTED)) {
			return true;
		}
		return false;
	}
}
