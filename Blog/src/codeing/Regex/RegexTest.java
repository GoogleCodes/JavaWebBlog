package codeing.Regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 
 * RegexTest
 * 创建人:菜鸟
 * 时间：2017年11月12日-上午9:08:46 
 * @version 1.0.0
 *
 */
public class RegexTest {
	public static List<String> getMailsByWeb() throws IOException {
		//1,读取源文件。
//				BufferedReader bufr = new BufferedReader(new FileReader("c:\\mail.html"));
		URL url = new URL("http://127.0.0.1:8080/Blog/index.jsp");
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(url.openStream()));	
		//2,对读取的数据进行规则的匹配。从中获取符合规则的数据.
		String mail_regex = "\\w+@\\w+(\\.\\w+)+";
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while((line=bufIn.readLine())!=null) {
			Matcher m = p.matcher(line);
			while(m.find()){
				//3,将符合规则的数据存储到集合中。
				list.add(m.group());
			}
		}
		return list;
	}

	public static List<String> getMails() throws IOException{
		//1,读取源文件。
		BufferedReader bufr = new BufferedReader(new FileReader("c:\\mail.html"));
		//2,对读取的数据进行规则的匹配。从中获取符合规则的数据.
		String mail_regex = "\\w+@\\w+(\\.\\w+)+";
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(mail_regex);
		String line = null;
		while((line=bufr.readLine())!=null) {
			Matcher m = p.matcher(line);
			while(m.find()){
				//3,将符合规则的数据存储到集合中。
				list.add(m.group());
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<String> list = null;
		try {
			list = getMailsByWeb();
			for(String mail : list) {
				System.out.println(mail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
