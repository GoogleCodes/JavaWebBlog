package codeing.bean;

import java.util.*;

/**
 * 
 * 
 * Upload
 * 创建人:菜鸟
 * 时间：2018年1月30日-下午9:35:01 
 * @version 1.0.0
 *
 */
public class Upload {
	
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	//	图片地址
	private String image_path;
	
	//	图片名称
	private String image_name;
	
	//	创建时间
	private String create_time;
	
	//	更新时间
	private Date update_time;
	
	//	删除时间
	private Date delete_time;
	
	//	用户ID
	private int user_id;

	private String image_title;
	
	public String getImage_title() {
		return image_title;
	}

	public void setImage_title(String image_title) {
		this.image_title = image_title;
	}

	public String getImage_path() {
		return image_path;
	}

	public String getImage_name() {
		return image_name;
	}

	public String getCreate_time() {
		return create_time;
	}

	public Date getDelete_time() {
		return delete_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public void setCreate_time(String dataString) {
		this.create_time = dataString;
	}


	public void setDelete_time(Date delete_time) {
		this.delete_time = delete_time;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

}
