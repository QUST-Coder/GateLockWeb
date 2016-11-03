package com.lock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.domain.FingerData;
import com.lock.domain.User;
import com.lock.service.UserRegistService;
import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;
/**
 * 用户注册Servlet
 * @author GarryChung
 * 需保证门锁已录入完成
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {

	public UserRegistServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置数据编码
		request.setCharacterEncoding("utf-8");
		//用于储存是否注册成功
		boolean result = false;
		//判断fingetData是否为空，为空代表尚未录入指纹
		if (StaticResource.fingerData != null) {
			User user = new User(request.getParameter("name"),request.getParameter("studentId"),request.getParameter("passWord"));
			FingerData fingerData = StaticResource.fingerData;
			UserRegistService userRegistService = new UserRegistService(user, fingerData);
			result = userRegistService.regist();
			//判断注册结果
			if (result) {
				//注册成功，置空所有的变量
				StaticResource.addResult = "";
				StaticResource.lockState = "";
				StaticResource.fingerData = null;
				request.getSession().setAttribute("result", "注册成功");
				response.sendRedirect(request.getContextPath() + "/regist.jsp");
			}else {
				request.getSession().setAttribute("result", "注册失败，请重新注册");
				response.sendRedirect(request.getContextPath() + "/regist.jsp");
			}
		}else {
			request.getSession().setAttribute("result", "注册失败，您还没有录入指纹！");
			response.sendRedirect(request.getContextPath() + "/regist.jsp");
		}
	}

	public void init() throws ServletException {
		
	}

}
