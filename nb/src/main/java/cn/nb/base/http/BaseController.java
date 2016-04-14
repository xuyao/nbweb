package cn.nb.base.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseController {
	
	protected Log log = LogFactory.getLog(getClass());
	
	protected int pageCount(int count , int pageNo ,int pageSize){		
		int currentPage = pageNo == 0 ? 1 : pageNo; //得到当前页
		int beginIndex = (currentPage - 1) * pageSize; //查询起始数
		int pagecount = count%pageSize == 0 ? count/pageSize : count/pageSize + 1;
		if (pageNo > pagecount) {
			pageNo = pagecount;
		}
		if (pageNo <= 0) {
			pageNo = 1;
		}
		return beginIndex;
	}
	
}
