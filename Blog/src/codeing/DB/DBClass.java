package codeing.DB;

//	导入Sql包
import java.sql.*;

/**
 * 
 * 
 * DBClass
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午9:22:16 
 * @version 1.0.0
 *
 */
public class DBClass {
	
	//	桥接
	private static String DRIVER = "com.mysql.jdbc.Driver";
	//	数据库地址
	private static String DBService = "qdm236565334.my3w.com";
	//	数据库名称
	private static String DBNAME = "qdm236565334_db";
	//	请求地址
	private static String URL = "jdbc:mysql://"+ DBService +":3306/"+ DBNAME +"";
	//	数据库帐号和密码
	private static String USERNAME = "qdm236565334";
	private static String PASSWORD = "xiuxian123";
	//	新建连接
	private static Connection CONN = null;
	
	/**
	 * 
	 * (打开数据库)
	 * 方法名：getConnection
	 * 创建人：cainiao 
	 * 时间：2017年10月31日-下午10:07:57 
	 * 手机:1564545646464 void
	 * @return 
	 * @exception 
	 * @since  1.0.0
	 */
	public Connection getConnection() {
		try {
			try {
				Class.forName(DRIVER);
			} catch (Exception e) {
				e.printStackTrace();
			}
			CONN = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("打开成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("打开失败！");
		}
		return CONN;
	}
	
	/**
	 * 
	 * (关闭数据)
	 * 方法名：getClose
	 * 创建人：cainiao
	 * 时间：2017年10月31日-下午10:06:48 
	 * 手机:1564545646464 void
	 * @exception 
	 * @since  1.0.0
	 */
	public void getCloseDB() {
		try {
			this.CONN.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
