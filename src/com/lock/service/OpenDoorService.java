package com.lock.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lock.dao.Dao;
import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;

public class OpenDoorService {
	String studentId = null;
	String passWord = null;
	public OpenDoorService(String studentId, String passWord) {
		super();
		this.studentId = studentId;
		this.passWord = passWord;
	}
	
	public int open() throws ClassNotFoundException, SQLException, IOException {
		Dao dao = new Dao();
		//查询用户密码
		String sql = "SELECT passWord FROM User WHERE studentID = "+studentId+";";
		ResultSet resultSet = dao.selectDate(sql);
		while (resultSet.next()) {
			String pass = resultSet.getString(0);
			if (pass == null) {
				//结果为空，返回用户不存在
				return 1;
			}else if (passWord.equals(pass)) {
				//密码匹配，开门
				String data = "{\"act\":\"openDoor\"}";
				new SocketUtil(StaticResource.socket, StaticResource.outputStream, StaticResource.inputStream).sendData(data);
				//将开门记录存入数据库(待写)
				
			}else {
				//密码不正确
				return 3;
			}
		}
		return 0;
	}
}
