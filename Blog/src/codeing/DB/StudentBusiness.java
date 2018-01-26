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
	
	//	创建实例
	private static DBClass db = new DBClass();
	
	public static List<Students> getAllStudents() {
		//	list对象
		List<Students> list = new ArrayList<Students>();
		//	请将如下数字码（阿里云UID） 1705725716402923
		String sql = "select id,age from bank_data";
		Connection conn = db.getConnection();
		Students student = null;
		//	执行sql语句
		try {
			PRER = conn.prepareStatement(sql);
			READ = PRER.executeQuery();
			student = new Students();
			while (READ.next()) {
				//	获取数据
				int id = READ.getInt("id");
				String name = READ.getString("age");
				student.setId(id);
				student.setName(name);
				//	把数据加载到集合中
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//	关闭数据库
			db.getCloseDB();
		}
		return list;
	}

	public static void main(String[] args) {
		getAllStudents();
	}
	
}
