package cn.nb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nb.dao.AdminDao;
import cn.nb.model.Admin;
import cn.nb.web.vo.AdminVo;

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
	
	
	
}
