package com.lock.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.lock.dao.Dao;
import com.lock.domain.OpenRecord;

public class WebOpenRecordService {
	String finger = null;
	String jsonString = null;
	public WebOpenRecordService(String jsonString) {
		this.jsonString = jsonString;
		savaOpenRecord();
	}
	
	public void savaOpenRecord() {
		Gson gson = new Gson();
		try {
			OpenRecord openRecord = gson.fromJson(jsonString, OpenRecord.class);
			if (openRecord.getFin() != -1) {
				//openRecord.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				String sql = "insert into OpenRecord(fin,time) values('"+openRecord.getFin()+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"');";
				Dao dao = new Dao();
				dao.insertDate(sql);
				dao.closeAll();
			}
		} catch (Exception e) {
			
		}
	}
}
