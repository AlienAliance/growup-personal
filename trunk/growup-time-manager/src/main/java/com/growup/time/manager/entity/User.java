package com.growup.time.manager.entity;

public class User {
	
	private long id;
	private String login;
	private String password;
	private int privacyStatus;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPrivacyStatus() {
		return privacyStatus;
	}
	public void setPrivacyStatus(int privacyStatus) {
		this.privacyStatus = privacyStatus;
	}
}
