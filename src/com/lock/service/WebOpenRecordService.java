package com.lock.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lock.dao.Dao;
/**
 * Web开门记录服务
 * @author GarryChung
 *
 */
public class WebOpenRecordService {
	Dao dao = new Dao();
	String studentId = null;
	public WebOpenRecordService(String studentId){
		this.studentId = studentId;
	}
	
	public void savaOpenRecord(){
				try {
					//插入数据库
					String sql = "insert into OpenRecord(studentId,time,way) values('"+studentId+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"','net');";
					dao.insertDate(sql);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("数据库异常");
				}
				dao.closeAll();
	}
}
