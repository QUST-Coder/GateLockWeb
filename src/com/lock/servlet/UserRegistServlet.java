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

@WebServlet("/FingerRegistServlet")
public class UserRegistServlet extends HttpServlet {

	public UserRegistServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(request.getParameter("name"),request.getParameter("studentId"),request.getParameter("passWord"));
		FingerData fingerData = StaticResource.fingerData;
		UserRegistService userRegistService = new UserRegistService(user, fingerData);
		boolean result = userRegistService.regist();
		if (result) {
			request.setAttribute("result", "注册成功");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else {
			request.setAttribute("result", "注册失败，请重新注册");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

	public void init() throws ServletException {
		
	}

}
