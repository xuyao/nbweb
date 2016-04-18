package cn.nb.base.http;

import cn.nb.base.http.BaseResponse;

public class JsonResponse<T> extends BaseResponse{

	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
