package com.lock.domain;

public class FingerData {
	private String studentId = null;
	private String fin1 = null;
	private String fin2 = null;
	private String fin3 = null;
	private String fin4 = null;
	private String fin5 = null;
	
	public FingerData(String studentId, String fin1, String fin2, String fin3,
			String fin4, String fin5) {
		super();
		this.studentId = studentId;
		this.fin1 = fin1;
		this.fin2 = fin2;
		this.fin3 = fin3;
		this.fin4 = fin4;
		this.fin5 = fin5;
	}
	public FingerData() {
		super();
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFin1() {
		return fin1;
	}
	public void setFin1(String fin1) {
		this.fin1 = fin1;
	}
	public String getFin2() {
		return fin2;
	}
	public void setFin2(String fin2) {
		this.fin2 = fin2;
	}
	public String getFin3() {
		return fin3;
	}
	public void setFin3(String fin3) {
		this.fin3 = fin3;
	}
	public String getFin4() {
		return fin4;
	}
	public void setFin4(String fin4) {
		this.fin4 = fin4;
	}
	public String getFin5() {
		return fin5;
	}
	public void setFin5(String fin5) {
		this.fin5 = fin5;
	}
	
	
}
