package codeing.Util;

import java.util.*;
import java.net.*;

/**
 *
 */
public class OpenIdUtil {

    public static String oauth2GetOpenid(String code) {
        //  appid
        String appid = "wx82bd98556e74419d";
        //  appsecret
        String appsecret = "8f73d8291d11331402290dc1e32c1fe2";
        //授权（必填）
        String grant_type = "authorization_code";
        //URL
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        //请求参数
        String params = "appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String data = HttpUtil.get(requestUrl, params);
        //解析相应内容（转换成json对象）
        String json = JackJsonUtils.toJson(data);
        return json;
    }

    public static void main(String[] args) {
        oauth2GetOpenid("");
    }

}
