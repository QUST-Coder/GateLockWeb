package com.lock.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.lock.dao.Dao;
import com.lock.domain.OpenRecord;

public class WebOpenRecordService {
	String studentId = null;
	public WebOpenRecordService(String studentId){
		this.studentId = studentId;
		savaOpenRecord();
	}
	
	public void savaOpenRecord(){
				String sql = "insert into OpenRecord(studentId,time) values('"+studentId+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"');";
				Dao dao = new Dao();
				try {
					dao.insertDate(sql);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dao.closeAll();
	}
}
