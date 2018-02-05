package codeing.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import codeing.Array.ListObject;
import codeing.Util.JackJsonUtils;
import codeing.Util.StatusHouse;
import codeing.Util.StringUtils;
import codeing.bean.Bank;
import codeing.bean.Upload;

/**
 * 
 * 
 * SelectFileImages
 * 创建人:菜鸟
 * 时间：2018年1月31日-下午9:53:45 
 * @version 1.0.0
 *
 */
public class SelectFileImages {

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
	
	public static List<Upload> getImages() {
		
		db = new DBClass();
		
		List<Upload> list = new ArrayList<Upload>();
		
		String sql = "select " + 
					"image_title," +
					"image_path," +
					"image_name," +
					"create_time " + "from t_uploads";
		
		/**
		 * 创建实例
		 */
		Connection conn = db.getConnection();
		Upload upload = null;
		try {
			PRER = conn.prepareStatement(sql);
			READ = PRER.executeQuery();
			while (READ.next()) {
				upload = new Upload();
				String imageTitle = READ.getString("image_title");
				String imagePath = READ.getString("image_path");
				String imageName = READ.getString("image_name");
				String createTime = READ.getString("create_time");
				upload.setImage_path(imagePath);
				upload.setImage_name(imageName);
				upload.setCreate_time(createTime);
				upload.setImage_title(imageTitle);
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
//		int size = list.size();
//		int i;
//		Bank bank = new Bank();
//		for(i = 0; i < size; i++) {
//			bank.setId(list.get(i).getId());
//			int id = bank.getId();
//			System.out.println(id);
//		}
		List<Upload> list = getImages();
	
//		ListObject listobj = new ListObject();
//		listobj.setItems(list);
//		listobj.setStatusObject(StatusHouse.COMMON_STATUS_OK);
//		String responseText = JackJsonUtils.toJson(listobj);
//		System.out.println(responseText);
	}

}
