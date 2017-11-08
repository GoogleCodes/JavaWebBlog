package codeing.User;

import java.util.*;

/**
 * 
 * 
 * IMessage
 * 创建人:菜鸟
 * 时间：2017年11月8日-下午10:40:56 
 * @version 1.0.0
 *
 */
public class IMessage {
	//	标题
	String title = null;
	//	描述
	String desc = null;
	// 	内容
	String content = null;
	// 	创建时间
	Date createTime = null;
	//	更新时间
	Date updateTime = null;
	//	删除时间
	int deleteTime = 0;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(int deleteTime) {
		this.deleteTime = deleteTime;
	}
	@Override
	public String toString() {
		return "IMessage [title=" + title + ", desc=" + desc + ", content="
				+ content + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", deleteTime=" + deleteTime + "]";
	}
}
