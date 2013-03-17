package com.growup.time.manager.exception;

public class TaskNotFoundException extends Exception {	
	
	private static final long serialVersionUID = 3074848317857903001L;

	public TaskNotFoundException() {
		super();
	}
	
	public TaskNotFoundException(Long userId) {
		super ("Task not found");
	}
}
