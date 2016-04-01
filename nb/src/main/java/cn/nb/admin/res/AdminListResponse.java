package cn.nb.admin.res;

import java.util.List;

import cn.nb.admin.model.Admin;
import cn.nb.base.http.BaseResponse;

public class AdminListResponse extends BaseResponse{

	List<Admin> rows;
	
	int total;
	
	public List<Admin> getRows() {
		return rows;
	}

	public void setRows(List<Admin> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
