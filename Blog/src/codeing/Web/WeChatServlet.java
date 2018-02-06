package codeing.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codeing.Util.OpenIdUtil;
import codeing.Util.ResponseUtils;

public class WeChatServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public WeChatServlet() {
        super();
    }
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		
		String loginCode = req.getParameter("code");
        String openid = OpenIdUtil.oauth2GetOpenid(loginCode);
        
        ResponseUtils.renderJson(resp, openid);
		
	}


	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		doGet(req, resp);
		
	}

}
