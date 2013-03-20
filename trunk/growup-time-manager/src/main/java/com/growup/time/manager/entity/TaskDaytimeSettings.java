package com.growup.time.manager.entity;

public class TaskDaytimeSettings {
	private long id;
	private long userId;
	private long daytime;	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getDaytime() {
		return daytime;
	}
	public void setDaytime(long daytime) {
		this.daytime = daytime;
	}	
}
