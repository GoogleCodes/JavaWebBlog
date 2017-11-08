package codeing.DB;

import java.sql.*;

import codeing.User.IMessage;

/**
 * 
 * 
 * INewMessage
 * 创建人:菜鸟
 * 时间：2017年11月8日-下午10:31:32 
 * @version 1.0.0
 *
 */
public class INewMessage {
	//	连接数据库
	private static Connection CONN = null;
	//	创建PreparedStatement
	private static PreparedStatement PRER = null;
	//	ResultSet
	private static ResultSet READ = null;
	//	创建实例
	private static DBClass db = new DBClass();
	
	/**
	 * 
	 * (增加数据)
	 * 方法名：setNewMessage
	 * 创建人：cainiao 
	 * 时间：2017年11月8日-下午10:52:25 
	 * 手机:1564545646464
	 * @param title
	 * @param desc
	 * @param content void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void setNewMessage(IMessage message) {
		CONN = db.getConnection();
		//	创建SQL连接
		String sql = "insert into tb_message(msg_title,msg_desc,msg_content) values (?,?,?)";
		try {
			PRER = CONN.prepareStatement(sql);
			PRER.setString(1, message.getTitle());
			PRER.setString(2, message.getDesc());
			PRER.setString(3, message.getContent());
			int row = PRER.executeUpdate();
			if (row > 0) {
				System.out.println(row);
			}
			System.out.println("成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败！");
		} finally {
			//	关闭数据库连接
			db.getCloseDB();
		}
	}
	
	public static void main(String[] args) {
		IMessage message = new IMessage();
		message.setTitle("1");
		message.setDesc("1");
		message.setContent("1");
		setNewMessage(message);
	}
	
}
