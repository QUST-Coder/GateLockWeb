package com.lock.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用户登录过滤器
 * @author GarryChung
 *
 */
@WebFilter(filterName="UserFilter",urlPatterns={"/apis","/regist.jsp"})  
public class UserFilter implements Filter {

    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String id = request.getParameter("id");
		String passWord = request.getParameter("passWord");
		
		if (id != null && passWord != null) {
			if (id.equals("549876099") && passWord.equals("zwb")) {
			chain.doFilter(request, response);
			} else {
				httpServletRequest.getSession().setAttribute("adminresult", "帐号或密码不正确！！");
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
			}
		}else {
			httpServletRequest.getSession().setAttribute("adminresult", "请先进行登录！！");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
		}
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
