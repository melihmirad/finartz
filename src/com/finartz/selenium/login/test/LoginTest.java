package com.finartz.selenium.login.test;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.finartz.selenium.login.service.ChromeService;
import com.finartz.selenium.login.service.LoginService;

class LoginTest {
	private ChromeService chromeService;
	private LoginService loginService;
	
	@BeforeEach
	void setup() {
		chromeService = new ChromeService();
		chromeService.setup();
		loginService = new LoginService(chromeService);
	}
	
	@AfterEach
	void close() {
		chromeService.stop();
	}

	@Test
	void testSuccessfulToLoginIfUsernameAndPasswordIsCorrect() {
		//GIVEN
		String userName = "testuser";
		String password = "testpass";
		
		//WHEN
		loginService.login(userName, password);
				
		//THEN
		Assert.assertTrue(loginService.isLoginSuccessful());
	}
	
	@Test
	void testFailToLoginIfUsernameAndPasswordIsIncorrect() {
		//GIVEN
		String userName = "username";
		String password = "password";
		
		//WHEN
		loginService.login(userName, password);
				
		//THEN
		Assert.assertFalse(loginService.isLoginSuccessful());
	}
	
	@Test
	void testFailToLoginIfUsernameIsCorrectAndPasswordIsIncorrect() {
		//GIVEN
		String userName = "testuser";
		String password = "password";
		
		//WHEN
		loginService.login(userName, password);
				
		//THEN
		Assert.assertFalse(loginService.isLoginSuccessful());
	}
	
	@Test
	void testAlertWarningMessageToLoginIfUsernameIsShorterThanFourCharacters() {
		//GIVEN
		String userName = "usr";
		String password = "12345";
				
		//WHEN
		loginService.login(userName, password);
		
		//THEN
		Assert.assertTrue(chromeService.isAlertPresent());
	}
	
	@Test
	void testAlertWarningMessageToLoginIfPasswordIsShorterThanFourCharacters() {
		//GIVEN
		String userName = "username";
		String password = "123";
				
		//WHEN
		loginService.login(userName, password);
		
		//THEN
		Assert.assertTrue(chromeService.isAlertPresent());
	}

}
