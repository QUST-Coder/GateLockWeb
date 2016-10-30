package com.lock.domain;

public class OpenRecord {
	int fin = -1;
	String time = null;
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public OpenRecord(int fin, String time) {
		super();
		this.fin = fin;
		this.time = time;
	}
	public OpenRecord() {
		super();
	}
	
}
