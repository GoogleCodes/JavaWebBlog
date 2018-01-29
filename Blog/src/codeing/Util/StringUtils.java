package codeing.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
 * 
 * StringUtils
 * 创建人:菜鸟
 * 时间：2018年1月27日-下午11:38:36 
 * @version 1.0.0
 *
 */
public class StringUtils {
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：isEmpty
	 * 创建人：xuchengfei 
	 * 时间：2018年1月27日-下午11:38:48 
	 * 手机:1564545646464
	 * @param content
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isEmpty(String content){
		return (content == null || content.equals(""))?true:false;
	}
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：isNotEmpty
	 * 创建人：xuchengfei 
	 * 时间：2018年1月27日-下午11:39:11 
	 * 手机:1564545646464
	 * @param content
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean isNotEmpty(String content){
		return !isEmpty(content);
	}
	
	
//	public static String base64Encode(byte[] b) {
//		if (b == null) {
//			return null;
//		}
//		return new BASE64Encoder().encode(b);
//	}
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：md5Base64
	 * 创建人：xuchengfei 
	 * 时间：2018年1月27日-下午11:39:36 
	 * 手机:1564545646464
	 * @param str
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
//	public static String md5Base64(String str) {
//		try {
//			MessageDigest md5 = MessageDigest.getInstance("MD5");
//			return base64Encode(md5.digest(str.getBytes()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：formatDate
	 * 创建人：xuchengfei 
	 * 时间：2018年1月27日-下午11:39:50 
	 * 手机:1564545646464
	 * @param date
	 * @param pattern
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String formatDate(Date date,String pattern){
		if(date!=null){
			String dateString = new SimpleDateFormat(pattern).format(date);
			return dateString;
		}else{
			return "";
		}
	}
	
	/**
	 * 
	 * (这里用一句话描述这个方法的作用)
	 * 方法名：getExt
	 * 创建人：xuchengfei 
	 * 时间：2018年1月27日-下午11:40:23 
	 * 手机:1564545646464
	 * @param name
	 * @param flag
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getExt(String name,boolean flag){
		if(isNotEmpty(name)){
			String ext  = null;
			if(flag){
				ext = name.substring(name.lastIndexOf("."), name.length());
			}else{
				ext = name.substring(name.lastIndexOf(".")+1, name.length());
			}
			return ext;
		}else{
			return "";
		}
	}
	
	
	public static String generateFileName(String fileName,int randomNum,String dataPattern) {
		
		DateFormat format = new SimpleDateFormat(dataPattern);
		
		String formatDate = format.format(new Date());
		
		int random = new Random().nextInt(randomNum);
		
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		
		return formatDate + random + extension;
	}
	
}
