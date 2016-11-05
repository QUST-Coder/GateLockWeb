package com.lock.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("adminresult", "请先进行登录！！");
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名密码并发送到session
		request.getSession().setAttribute("id", request.getParameter("id"));
		request.getSession().setAttribute("passWord", request.getParameter("passWord"));
		//转发到用户注册
		response.sendRedirect(request.getContextPath() + "/admin/menu.jsp");
	}

}
