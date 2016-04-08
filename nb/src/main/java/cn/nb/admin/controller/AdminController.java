package cn.nb.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.nb.admin.model.Admin;
import cn.nb.admin.res.AdminListResponse;
import cn.nb.admin.service.AdminService;
import cn.nb.base.http.HttpResponse;
import cn.nb.base.http.Page;
import cn.nb.util.JsonUtil;
import cn.nb.web.controller.BaseController;

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
		AdminListResponse ares = new AdminListResponse();
		Admin admin = new Admin();
		List<Admin> list = adminService.list(admin);
		ares.setRows(list);
		ares.setTotal(1);
		HttpResponse.responseContentTypeJson(response, JsonUtil.getJsonString4JavaPOJO(ares));
	}

	
}
