package cn.nb.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nb.admin.dao.AdminDao;
import cn.nb.admin.model.Admin;
import cn.nb.admin.vo.AdminVo;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public boolean exitAdmin(AdminVo adminVo){
		Admin admin = new Admin();
		admin.setName(adminVo.getUsername());
		admin.setPassword(adminVo.getPassword());
		Integer result = adminDao.count(admin);
		if(result==0)
			return false;
		else
			return true;
	}
	
	
	public List<Admin> list(AdminVo adminVo){
		Admin admin = new Admin();
		admin.setName(adminVo.getUsername());
		admin.setPassword(adminVo.getPassword());
		return adminDao.search(admin);
	}
	
	
	
}
