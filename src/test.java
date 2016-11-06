import java.sql.ResultSet;
import java.sql.SQLException;

import com.lock.dao.Dao;


public class test {
	Dao dao = new Dao();
	String id = "" ;
	
	public static void main(String[] args) {
		System.out.println(new test().select("1408070104"));
	}
	
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
