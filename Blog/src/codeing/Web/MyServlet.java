package codeing.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeing.Array.ListObject;
import codeing.Commit.StudentServiceImpl;
import codeing.User.Students;

import java.util.*;

import codeing.User.*;
import codeing.Util.JackJsonUtils;
import codeing.Util.ResponseUtils;
import codeing.Util.StatusHouse;


/**
 * 
 * 
 * MyServlet
 * 创建人:菜鸟
 * 时间：2017年10月31日-下午8:58:22 
 * @version 1.0.0
 *
 */
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Students> list = new StudentServiceImpl().getAllStudents();
		System.out.println(list);
//		ListObject listObject = new ListObject();
//		listObject.setItems(list);
//		listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
//	    String responseText = JackJsonUtils.toJson(listObject);
//	    ResponseUtils.renderJson(response, responseText);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}

}
