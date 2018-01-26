package codeing.User;

/**
 * 
 * 
 * Students
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午9:00:28 
 * @version 1.0.0
 *
 */
public class Students {
	//	ID
	private int id;
	//	NAME
	private String name;
	//	描述
	private String desc;
	//	具体内容
	private String content;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
