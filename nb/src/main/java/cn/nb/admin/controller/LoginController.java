package cn.nb.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.nb.admin.model.Admin;
import cn.nb.admin.service.AdminService;
import cn.nb.web.controller.BaseController;

/**
 * 	登录controller
 * 	@author xuyao
 * */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Admin admin, HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		admin.setName(name);
		admin.setPassword(password);
		
		ModelAndView mav = new ModelAndView();
		
		if(adminService.exitAdmin(admin)){
			request.getSession().setAttribute("Admin", admin);
			mav.setViewName("main.jsp");
			System.out.println(name+" login!");
		}else{
			request.getSession().setAttribute("Admin", null);
			mav.setViewName("index.jsp");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(Admin admin, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();	
		if(request.getSession().getAttribute("Admin")!=null)
				request.getSession().removeAttribute("Admin");
		mav.setViewName("index.jsp");
		return mav;
	}
	
	
}
