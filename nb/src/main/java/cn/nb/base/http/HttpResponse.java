package cn.nb.base.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 	@author xuyao 
 * */
public class HttpResponse {

	public static void responseContentTypeJson(HttpServletResponse response, String rs){
		response.setContentType(ContentType.ACCEPT_JSON);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response(response, rs);
	}
	
	public static void response(HttpServletResponse response,String rs,String format){
		response.setContentType(ContentType.getResponseContentType(format));
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response(response,rs);
	}
	
	public static void responsePlainText(HttpServletResponse response, String rs){
		response.setContentType(ContentType.TEXT_PLAIN);
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response(response, rs);
	}
	
	public static void response(HttpServletResponse response,String rs){
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(rs);			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

}