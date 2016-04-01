package cn.nb.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.nb.base.http.HttpResponse;
import cn.nb.web.vo.Admin;

/**
 * 	登录controller
 * 	@author xuyao
 * */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	
	@RequestMapping(value = "/do", method = RequestMethod.POST)
	public void clist(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//do search database
		Admin admin = new Admin();
		admin.setUsername(username);
		request.getSession().setAttribute("Admin", admin);
		System.out.println(username+" "+password);
		//HttpResponse.responseContentTypeJson(response, "");
	}
	
}
