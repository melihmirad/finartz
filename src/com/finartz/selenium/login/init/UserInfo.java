package com.finartz.selenium.login.init;

import java.util.HashMap;
import java.util.Map;

public class UserInfo {

	private Map<String, String> loginInfo;
	
	public UserInfo() {
		loginInfo = new HashMap<>();
	}
	
	public void initialize() {
		loginInfo.put("usr", "12435");
		//loginInfo.put("user1", "password"); // login failed case
		//loginInfo.put("testuser","testpass"); // login successfull case
		//loginInfo.put("melih", "1234"); // login failed case
	}
	
	public Map<String, String> getLoginInfo(){
		return loginInfo;
	}
}
