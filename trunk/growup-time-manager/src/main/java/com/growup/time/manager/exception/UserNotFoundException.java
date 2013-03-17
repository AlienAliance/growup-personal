package com.growup.time.manager.exception;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = 3014295387632320529L;
	
	public UserNotFoundException() {
		super();
	}
	
	public UserNotFoundException(Long userId) {
		super("User with id " + userId + " was not found");
	}

	public UserNotFoundException(String nickName) {
		super("User with nick " + nickName + " was not found");
	}

}
