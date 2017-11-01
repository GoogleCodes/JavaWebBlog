package codeing.Util;

/**
 * 
 * 
 * StatusObject
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午8:51:55 
 * @version 1.0.0
 *
 */
public class StatusObject {
    private String code;
  
    private String msg;
  
    public StatusObject(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
  
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
}
