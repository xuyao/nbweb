package cn.nb.admin.dao;

import java.util.List;

import cn.nb.admin.model.Admin;
import cn.nb.base.annotation.MybatisMapper;

@MybatisMapper
public interface AdminDao {

	public Integer count(Admin admin);
	
	public List<Admin> search(Admin admin);
	
	public void save(Admin admin);
	
	public void update(Admin admin);
	
	public void delete(Admin admin);
	
}
