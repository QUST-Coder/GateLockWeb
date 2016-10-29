package com.lock.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;

public class FingerRegistServlet extends HttpServlet {

	public FingerRegistServlet() {
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
		SocketUtil socketUtil = new SocketUtil(StaticResource.socket,StaticResource.outputStream,StaticResource.inputStream);
		socketUtil.sendData("hello");
	}

	public void init() throws ServletException {
		
	}

}
