package cn.nb.base.http;

import javax.xml.bind.annotation.XmlRootElement;

import cn.nb.util.DateUtil;

/**
 * @author xuyao
 * 
 */
@XmlRootElement(name = "status")
public class Status {

	private int code;
	private String message;
	private String operation_at;

	public Status() {
	}

	public Status(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOperation_at() {
		return DateUtil.getNowformatLongPattern();
	}

	public void setOperation_at(String operation_at) {
		this.operation_at = operation_at;
	}

}
