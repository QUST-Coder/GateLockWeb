package com.lock.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.lock.dao.Dao;

public class SocketOpenRecordService {
	Dao dao = new Dao();
	Gson gson = new Gson();
	String fin = null;
	String studentId = null;
	
	public SocketOpenRecordService(String fin){
		this.fin = fin;
		
	}
	
	public void savaOpenRecord(){
		String selectStudentIdSql = "SELECT studentId FROM FingerDate "
				+ "WHERE fin1 = "+fin+"or fin2 = "+fin+" or fin3 = "+fin+" or fin4 = "+fin+" or fin5 = "+fin+" ;";
		ResultSet resultSet;
		try {
			resultSet = dao.selectDate(selectStudentIdSql);
			//读取用户ID
			while (resultSet.next()) {
				studentId = resultSet.getString(1);
			}
			//插入用户开门记录
			String insertOpenRecordSql = "insert into OpenRecord(studentId,time) values('"+studentId+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"');";
			dao.insertDate(insertOpenRecordSql);
			dao.closeAll();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库异常");
		}
		}
}
