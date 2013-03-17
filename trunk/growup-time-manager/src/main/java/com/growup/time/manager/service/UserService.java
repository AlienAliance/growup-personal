package com.growup.time.manager.service;

import com.growup.base.connection.ConnectionPool;
import com.growup.time.manager.dao.TaskManagementDao;
import com.growup.time.manager.dao.UserManagementDao;

public class UserService {
	
	private static final UserService SERVICE = new UserService();
	private UserManagementDao userDao = new UserManagementDao();
	private TaskManagementDao tasksDao = new TaskManagementDao();
	
	public static final UserService getService() {
		return SERVICE;
	}
	
}
