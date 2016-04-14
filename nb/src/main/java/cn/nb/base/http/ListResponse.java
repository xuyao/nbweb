package cn.nb.base.http;

import java.util.List;

import cn.nb.base.http.BaseResponse;

public class ListResponse<T> extends BaseResponse{

	List<T> rows;
	
	int total;
	
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
