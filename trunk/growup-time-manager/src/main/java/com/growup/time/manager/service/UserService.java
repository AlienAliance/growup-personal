package com.growup.time.manager.service;

public class UserService {
	
	private static final UserService SERVICE = new UserService();
	
	public static final UserService getService() {
		return SERVICE;
	}
	
}
