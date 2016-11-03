package com.lock.service;

import java.sql.SQLException;

import com.lock.dao.Dao;
import com.lock.domain.FingerData;
import com.lock.domain.User;
/**
 * 用户注册服务
 * @author GarryChung
 *
 */
public class UserRegistService {
	Dao dao = new Dao();
	User user = null;
	FingerData fingerData = null;
	public UserRegistService(User user, FingerData fingerData) {
		super();
		this.user = user;
		this.fingerData = fingerData;
	}
	
	public boolean regist(){
		String insertUserSql = "insert into User values('"+user.getName()+"','"+user.getStudentId()+"','"+user.getPassWord()+"')";
		String insertFingerSql = "insert into FingerData values('"+user.getStudentId()+"','"+fingerData.getFin1()+"','"+fingerData.getFin2()+"','"+fingerData.getFin3()+"','"+fingerData.getFin4()+"','"+fingerData.getFin5()+"')";
		try {
			dao.insertDate(insertUserSql);
			dao.insertDate(insertFingerSql);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			System.out.println("用户注册数据库异常");
			return false;
		}
		return true;
	}
}
