package codeing.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

import codeing.User.Students;

/**
 * 
 * 
 * StudentBusiness
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午9:12:54 
 * @version 1.0.0
 *
 */
public class StudentBusiness {

	private static PreparedStatement PRER = null;
	private static ResultSet READ = null;
	
	public static List<Students> getAllStudents() {
		//	list对象
		List<Students> list = new ArrayList<Students>();
<<<<<<< 0e0999d7aed2b9a29b4f790418ad753bc57791c3
		String sql = "select * from tb_nav";
		DBClass db = new DBClass();
		Connection conn = db.getConnection();
		Students student = new Students();
=======
		Students student = new Students();
		String sql = "select * from tb_nav";
		DBClass db = new DBClass();
		Connection conn = db.getConnection();
>>>>>>> c8c185df977f08ab411c41e62873941d4fed517c
		//	执行sql语句
		try {
			PRER = conn.prepareStatement(sql);
			READ = PRER.executeQuery();
			while (READ.next()) {
				//	获取数据
				int id = READ.getInt(1);
				String name = READ.getString(2);
				String url = READ.getString(6);
				student.setId(id);
				student.setName(name);
				student.setUrl(url);
				//	把数据加载到集合中
				list.add(student);
			}
			//	关闭数据库
			db.getCloseDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< 0e0999d7aed2b9a29b4f790418ad753bc57791c3
=======
		
//		student.setId(1);
//		student.setName("name");
//		//	把数据加载到集合中
//		list.add(student);
>>>>>>> c8c185df977f08ab411c41e62873941d4fed517c
		return list;
	}

	public static void main(String[] args) {
		getAllStudents();
	}
	
}
