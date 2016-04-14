package cn.nb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.nb.base.http.BaseController;
import cn.nb.base.http.HttpResponse;
import cn.nb.base.http.ListResponse;
import cn.nb.base.http.Page;
import cn.nb.model.Admin;
import cn.nb.service.AdminService;
import cn.nb.util.JsonUtil;


/**
 * 	登录controller
 * 	@author xuyao
 * */
@Controller
@RequestMapping("/fw/admin")
public class AdminController extends BaseController{
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Page page, HttpServletRequest request, HttpServletResponse response) {
		ListResponse<Admin> ares = new ListResponse<Admin>();
		Admin admin = new Admin();
		List<Admin> list = adminService.list(admin);
		ares.setRows(list);
		ares.setTotal(1);
		HttpResponse.responseContentTypeJson(response, JsonUtil.getJsonString4JavaPOJO(ares));
	}

	
}
