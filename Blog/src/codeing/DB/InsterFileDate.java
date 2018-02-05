package codeing.DB;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import codeing.Array.ListObject;
import codeing.Util.JackJsonUtils;
import codeing.Util.StatusHouse;
import codeing.bean.Upload;

/**
 * 保存上传图片路径
 * 
 * InsterFileDate
 * 创建人:菜鸟
 * 时间：2018年1月30日-下午9:14:13 
 * @version 1.0.0
 *
 */
public class InsterFileDate {

	/**
	 * PRER
	 */
	private static PreparedStatement PRER = null;
	
	/**
	 * READ
	 */
	private static ResultSet READ = null;
	
	/**
	 * 创建实例
	 */
	private static DBClass db = null;
	
	
	public static void SaveFilePath(Upload upload) {
		
		/**
		 * 实例化对象
		 */
		db = new DBClass();
		
		/**
		 * 创建sql 语句
		 */
		String sql = "insert into t_uploads (image_path, image_name, create_time, image_title) values (?,?,?,?)";
		
		/**
		 * 创建实例
		 */
		Connection conn = db.getConnection();
		
		try {
			PRER = conn.prepareStatement(sql);
			PRER.setString(1, upload.getPath());
//			PRER.setString(1, upload.getImage_path());
			PRER.setString(2, upload.getImage_name());
			PRER.setString(3, upload.getCreate_time());
			PRER.setString(4, upload.getImage_title());
			int row = PRER.executeUpdate();
			if (row > 0) {
				System.out.println(row);
			}
			System.out.println("插入成功");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//	关闭数据库
			db.getCloseDB();
		}
		
	}
	
	public static void main(String[] args) {
		Upload uploads = new Upload();
		uploads.setImage_path("E:\\app\\home\\image");
		uploads.setImage_name("123");
		
//		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String dataString = format.format(new Date());
//			uploads.setCreate_time(dataString);
//			SaveFilePath(uploads);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
