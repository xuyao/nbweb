package cn.nb.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.nb.web.vo.AdminVo;


/**
 * 接口访问权限限制
 * @author xuyao
 */
public class PermissionFilter implements Filter {
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		AdminVo admin = (AdminVo)session.getAttribute("AdminVo");
		if(admin!=null){
			chain.doFilter(req, response);
		}else{
			rep.sendRedirect("../index.jsp");
		}
	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
