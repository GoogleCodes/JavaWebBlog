package codeing.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 
 * JackJsonUtils
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午8:52:08 
 * @version 1.0.0
 *
 */
public class JackJsonUtils {

	static ObjectMapper objectMapper;
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：fromJson
	 * 创建人：菜鸟
	 * 时间：2017年10月31日-下午8:50:04 
	 * 手机:1564545646464
	 * @param content
	 * @param valueType
	 * @return T
	 * @exception 
	 * @since  1.0.0
	 */
	public static <T> T fromJson(String content, Class<T> valueType) {  
        if (objectMapper == null) {  
            objectMapper = new ObjectMapper();  
        }  
        try {  
            return objectMapper.readValue(content, valueType);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：toJson
	 * 创建人：菜鸟
	 * 时间：2017年10月31日-下午8:50:17 
	 * 手机:1564545646464
	 * @param object
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String toJson(Object object) {  
        if (objectMapper == null) {  
            objectMapper = new ObjectMapper();  
        }  
        try {  
            return objectMapper.writeValueAsString(object);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }
	
}
