package cn.nb.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nb.admin.dao.AdminDao;
import cn.nb.admin.model.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public boolean exitAdmin(Admin admin){
		Integer result = adminDao.count(admin);
		if(result==0)
			return false;
		else
			return true;
	}
	
	
	public List<Admin> list(Admin admin){
		return adminDao.search(admin);
	}
	
	
	public Integer count(Admin admin){
		return adminDao.count(admin);
	}
	
}
