package cn.nb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nb.dao.AdminDao;
import cn.nb.model.Admin;

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
	
	
	public void save(Admin admin){
		adminDao.save(admin);
	}
	
	
	public void update(Admin admin){
		adminDao.update(admin);
	}
	
	public void delete(Admin admin){
		adminDao.delete(admin);
	}
	
}
