package com.lock.domain;

public class User {
	private String name = null;
	private String studentId = null;
	private String passWord = null;
	
	public User() {
		super();
	}
	public User(String name, String studentId, String passWord) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.passWord = passWord;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
