package cn.nb.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.nb.service.AdminService;
import cn.nb.web.vo.AdminVo;

/**
 * 	登录controller
 * 	@author xuyao
 * */
@Controller
@RequestMapping("/fw")
public class AdminController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public ModelAndView clist(AdminVo adminVo, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("list",list);
		mav.setViewName("/fw/admin_table.jsp");
		return mav;
	}
	
}
