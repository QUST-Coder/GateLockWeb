package com.lock.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lock.dao.Dao;
/**
 * 用户ID查重
 * @author GarryChung
 *
 */
public class IdDetectionService {
	private Dao dao = new Dao();
	private String id = "";
	
	public String select(String studentId) {
				String sql = "SELECT studentId FROM User WHERE studentID = "+studentId+";";
				try {
					ResultSet resultSet = dao.selectDate(sql);
					while (resultSet.next()) {
						id = resultSet.getString(1);
					}
					dao.closeAll();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("用户ID查重数据库异常");
				}
				return id;
	}
}
