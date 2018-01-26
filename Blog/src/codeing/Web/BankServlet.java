package codeing.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeing.Array.ListObject;
import codeing.Commit.BankServiceImpl;
import codeing.DB.BankInformation;
import codeing.Util.JackJsonUtils;
import codeing.Util.ResponseUtils;
import codeing.Util.StatusHouse;
import codeing.bean.*;

import java.util.*;


public class BankServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		List<Bank> list = BankInformation.getBankMessage();
		ListObject listobj = new ListObject();
		listobj.setItems(list);
		listobj.setStatusObject(StatusHouse.COMMON_STATUS_OK);
		String responseText = JackJsonUtils.toJson(listobj);
	    ResponseUtils.renderJson(resp, responseText);
		System.out.println(responseText);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8s");
		PrintWriter out = resp.getWriter();
		
	}

}
