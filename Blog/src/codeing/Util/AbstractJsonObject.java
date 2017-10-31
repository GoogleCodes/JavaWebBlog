package codeing.Util;

import java.util.*;

/**
 * 
 * 
 * AbstractJsonObject
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午8:51:39 
 * @version 1.0.0
 *
 */
public class AbstractJsonObject {
	//	code
	private String code;
	// msg
	private String msg;
	//	time
	private Long time = new Date().getTime();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public void setStatusObject(StatusObject statusObject) {  
        this.code = statusObject.getCode();  
        this.msg = statusObject.getMsg();  
    }
}
