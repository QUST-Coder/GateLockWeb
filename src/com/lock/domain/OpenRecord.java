package com.lock.domain;

public class OpenRecord {
	String fin = null;
	String time = null;
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public OpenRecord(String fin, String time) {
		super();
		this.fin = fin;
		this.time = time;
	}
	public OpenRecord() {
		super();
	}
	
}
