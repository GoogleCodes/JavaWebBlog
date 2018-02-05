package codeing.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeing.Array.ListObject;
import codeing.DB.SelectFileImages;
import codeing.Util.JackJsonUtils;
import codeing.Util.ResponseUtils;
import codeing.Util.StatusHouse;
import codeing.bean.Upload;

import java.util.*;

/**
 * 
 * 
 * ImagesServlet
 * 创建人:菜鸟
 * 时间：2018年1月31日-下午10:34:47 
 * @version 1.0.0
 *
 */
public class ImagesServlet extends HttpServlet {

	public ImagesServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		List<Upload> list = SelectFileImages.getImages();
		ListObject listobj = new ListObject();
		listobj.setItems(list);
		listobj.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listobj);
	    ResponseUtils.renderJson(resp, responseText);
		System.out.println(responseText);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
		resp.setContentType("text/html;charset=utf-8");
		
	}

}
