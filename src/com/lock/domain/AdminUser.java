package com.lock.domain;

public class AdminUser {
	String id = null;
	String passWord = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public AdminUser(String id, String passWord) {
		super();
		this.id = id;
		this.passWord = passWord;
	}
	public AdminUser() {
		super();
	}
}
