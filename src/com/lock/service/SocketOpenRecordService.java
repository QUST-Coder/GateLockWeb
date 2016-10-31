package com.lock.service;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.lock.dao.Dao;
import com.lock.domain.OpenRecord;

public class SocketOpenRecordService {
	String finger = null;
	String jsonString = null;
	public SocketOpenRecordService(String jsonString) {
		this.jsonString = jsonString;
		savaOpenRecord();
	}
	
	public void savaOpenRecord() {
		Gson gson = new Gson();
		try {
			OpenRecord openRecord = gson.fromJson(jsonString, OpenRecord.class);
			//判断是否是存储开门记录的Socket
			if (openRecord.getFin() != -1) {
				int fin = openRecord.getFin();
				Dao dao = new Dao();
				String selectStudentIdSql = "SELECT studentId FROM FingerDate WHERE fin1 = "+fin+"or fin2 = "+fin+" or fin3 = "+fin+" or fin4 = "+fin+" or fin5 = "+fin+" ;";
				ResultSet resultSet = dao.selectDate(selectStudentIdSql);
				String studentId = null;
				while (resultSet.next()) {
					studentId = resultSet.getString(0);
				}
				
				String insertOpenRecordSql = "insert into OpenRecord(studentId,time) values('"+studentId+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"');";
				dao.insertDate(insertOpenRecordSql);
				dao.closeAll();
			}
		} catch (Exception e) {
			
		}
	}
}
