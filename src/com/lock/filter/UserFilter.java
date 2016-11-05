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

import com.lock.domain.AdminUser;
import com.lock.service.AdminLoginService;
/**
 * 管理员登录过滤器
 * @author GarryChung
 *
 */
@WebFilter(filterName="UserFilter",urlPatterns={"/apis/*","/admin/*"})  
public class UserFilter implements Filter {

    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//准备Response和Request对象
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//存储用户名密码
		String id = (String) httpServletRequest.getSession().getAttribute("id");
		String passWord = (String) httpServletRequest.getSession().getAttribute("passWord");
		//判断是否为空，为空代表未登录过
		if (id != null && passWord != null) {
			//存储对象，传递并返回判断结果
			AdminUser adminUser = new AdminUser(id, passWord);
			boolean res = new AdminLoginService(adminUser).login();
			//判断是否登录成功
			if (res) {
				//登录成功，放行
				chain.doFilter(request, response);
			} else {
				//登录失败
				httpServletRequest.getSession().setAttribute("adminresult", "帐号或密码不正确！！");
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login.jsp");
			}
		}else {
			//尚未登录
			httpServletRequest.getSession().setAttribute("adminresult", "管理员操作，请先进行登录！！");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
