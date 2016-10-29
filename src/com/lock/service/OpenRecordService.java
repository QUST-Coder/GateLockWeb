package com.lock.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.lock.domain.OpenRecord;

public class OpenRecordService {
	String finger = null;
	String jsonString = null;
	public OpenRecordService(String jsonString) {
		this.jsonString = jsonString;
		savaOpenRecord();
	}
	
	public void savaOpenRecord() {
		Gson gson = new Gson();
		try {
			OpenRecord openRecord = gson.fromJson(jsonString, OpenRecord.class);
			openRecord.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			System.out.println(openRecord.getFin() + "~~~"+ openRecord.getTime());
		} catch (Exception e) {
			System.out.println("json非法");
		}
		
		
	}
}
