package com.lock.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lock.dao.Dao;
import com.lock.domain.AdminUser;

public class AdminLoginService {
	AdminUser adminUser = null;
	Dao dao = new Dao();
	String pass = "";
	public	AdminLoginService(AdminUser adminUser) {
		super();
		this.adminUser = adminUser;
	}
	
	public boolean login() {
		String sql = "SELECT passWord FROM AdminUser WHERE id = \""+adminUser.getId()+"\"";
		try {
			//返回查询结果
			ResultSet resultSet = dao.selectDate(sql);
			while (resultSet.next()) {
				//获得密码
				pass = resultSet.getString(0);
				//判断密码是否匹配
				if (pass.equals(adminUser.getPassWord())) {
					dao.closeAll();
					return true;
				}
				dao.closeAll();
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("管理员登录数据库异常");
		}
		
		return false;
	}
	
	
}