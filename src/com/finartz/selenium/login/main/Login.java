package com.finartz.selenium.login.main;


import java.util.Map.Entry;
import java.util.logging.Logger;

import com.finartz.selenium.login.init.UserInfo;
import com.finartz.selenium.login.service.ChromeService;
import com.finartz.selenium.login.service.LoginService;

public class Login {

	final static Logger LOG = Logger.getLogger(Login.class.getName());
	
	public static void main(String[] args) throws InterruptedException {
		ChromeService chromeService = new ChromeService();
		LoginService loginService;
		UserInfo userInfo = new UserInfo();
		userInfo.initialize();
		
		for(Entry<String, String> entry : userInfo.getLoginInfo().entrySet())
		{
			chromeService.setup();
			LOG.info("Chrome service has been set up...");
			
			loginService = new LoginService(chromeService);
			loginService.login(entry.getKey(), entry.getValue());

			if(loginService.isLoginSuccessful()) {
				System.out.println("Login successful...");
			}else {
				System.out.println("Login failed...");
			}
			
			chromeService.stop();	
		}		
		
	}

}
