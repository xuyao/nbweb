package cn.nb.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.nb.admin.service.AdminService;
import cn.nb.admin.vo.AdminVo;
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
	public ModelAndView login(AdminVo adminVo, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		adminVo.setUsername(username);
		adminVo.setPassword(password);
		
		ModelAndView mav = new ModelAndView();
		
		if(adminService.exitAdmin(adminVo)){
			request.getSession().setAttribute("Admin", adminVo);
			mav.setViewName("main.jsp");
			System.out.println(username+" login!");
		}else{
			request.getSession().setAttribute("Admin", null);
			mav.setViewName("index.jsp");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(AdminVo adminVo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();	
		if(request.getSession().getAttribute("Admin")!=null)
				request.getSession().removeAttribute("Admin");
		mav.setViewName("index.jsp");
		return mav;
	}
	
	
}
