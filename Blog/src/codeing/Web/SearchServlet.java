package codeing.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeing.Array.ListObject;
import codeing.DB.BankSearch;

import java.util.*;

import codeing.Util.JackJsonUtils;
import codeing.Util.ResponseUtils;
import codeing.Util.StatusHouse;
import codeing.bean.*;

public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public SearchServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		doPost(req, resp);
		
		resp.setContentType("text/html;charset=utf-8");
	
//		BankSearch search = new BankSearch();
//		String content = null;
//		List<Bank> list = BankSearch.searchBank("4");
//		ListObject listobj = new ListObject();
//		listobj.setItems(list);
//		listobj.setStatusObject(StatusHouse.COMMON_STATUS_OK);
//		String responseText = JackJsonUtils.toJson(listobj);
//	    ResponseUtils.renderJson(resp, responseText);
//		System.out.println(responseText);
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		doGet(req, resp);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String content = req.getParameter("content");
		List<Upload> list = BankSearch.searchBank(content);
		ListObject listobj = new ListObject();
		listobj.setItems(list);
		listobj.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listobj);
	    ResponseUtils.renderJson(resp, responseText);
		System.out.println(responseText);
		
	}

}
