import java.sql.SQLException;

import com.lock.dao.Dao;


public class test {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		try {
			dao.insertDate("insert into User values('都是废物','33821','123')");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库异常");
			e.printStackTrace();
		}
	}

}
