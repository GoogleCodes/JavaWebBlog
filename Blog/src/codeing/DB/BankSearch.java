package codeing.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codeing.bean.*;

import java.util.*;

public class BankSearch {
	
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
	
	public static List<Upload> searchBank(String content) {
		
		db = new DBClass();
		
		List<Upload> list = new ArrayList<Upload>();
		
		/**
		 * Sql语句
		 */
		String sql = "select image_title, image_path, image_name, create_time from t_uploads where image_title LIKE ?";
		
		/**
		 * 创建实例
		 */
		Connection conn = db.getConnection();
		Upload upload = null;
		try {
			PRER = conn.prepareStatement(sql);
			PRER.setString(1, '%'+ content +'%');
			READ = PRER.executeQuery();
			while(READ.next()) {
				upload = new Upload();
				String imageTitle = READ.getString("image_title");
				String imagePath = READ.getString("image_path");
				String imageName = READ.getString("image_name");
				String createTime = READ.getString("create_time");

				upload.setImage_title(imageTitle);
				upload.setImage_path(imagePath);
				upload.setImage_name(imageName);
				upload.setCreate_time(createTime);
				list.add(upload);
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
		BankSearch search = new BankSearch();
		search.searchBank("123");
	}
	
}
