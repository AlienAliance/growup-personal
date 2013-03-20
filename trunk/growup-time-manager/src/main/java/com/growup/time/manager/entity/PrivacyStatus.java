package com.growup.time.manager.entity;

public class PrivacyStatus {
	private int id;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public enum Status {
		PRIVATE("private"),
		PUBLIC("public");
		private final String status;
		private Status(String status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return this.status;
		}
	}
}
