package cn.nb.dao;

import cn.nb.base.annotation.MybatisMapper;
import cn.nb.model.Admin;

@MybatisMapper
public interface AdminDao {

	public Integer count(Admin admin);
	
}
