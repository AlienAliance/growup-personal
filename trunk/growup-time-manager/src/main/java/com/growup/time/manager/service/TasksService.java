package com.growup.time.manager.service;

import com.growup.time.manager.dao.TaskManagementDao;

public class TasksService {
	
	private static final TasksService SERVICE = new TasksService();
	private TaskManagementDao taskDao = new TaskManagementDao();
	
	public static final TasksService getService() {
		return SERVICE;
	}
	
}
