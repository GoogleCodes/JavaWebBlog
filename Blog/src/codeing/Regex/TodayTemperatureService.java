package codeing.Regex;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

/**
 * 描述：趴取网页上的今天的天气
 * 
 * TodayTemperatureService 创建人:菜鸟 时间：2017年12月2日-下午11:24:57
 * 
 * @version 1.0.0
 *
 */
public class TodayTemperatureService {

	private static StringBuffer buffer = null;
	private static BufferedReader bufferedReader = null;
	private static InputStreamReader inputStreamReader = null;
	private static InputStream inputStream = null;
	private static HttpURLConnection httpUrlConn = null;
	
	private static String httpRequest(String requestUrl) {
		

		try {
			// 建立get请求
			URL url = new URL(requestUrl);
			httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");
			// 获取输入流
			inputStream = httpUrlConn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);
			// 从输入流读取结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
		} catch (Exception e) {

		} finally {
			// 释放资源
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (inputStreamReader != null) {
					inputStreamReader.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
				if (httpUrlConn != null) {
					httpUrlConn.disconnect();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	private static String htmlFiter(String html) {
		buffer = new StringBuffer();
		String str1 = "";
		String str2 = "";
		buffer.append("今天:");
		// 取出有用的范围
		Pattern p = Pattern.compile("(.*)(<body>)(.*?)(</body>)(.*)");
		Matcher m = p.matcher(html);
		if (m.matches()) {
			str1 = m.group(3);
			buffer.append(str1);
			buffer.append("\n天气：");
		}
		return buffer.toString();
	}

	public static String getTodayTemperatureInfo() {
		// 调用第一个方法，获取html字符串
		String html = httpRequest("https://www.getcodeing.com");
		// 调用第二个方法，过滤掉无用的信息
		String result = htmlFiter(html);
		return result;  
	}
	
	public static void main(String[] args) {
		String info = getTodayTemperatureInfo();
		System.out.println(info);
	}
	
}
