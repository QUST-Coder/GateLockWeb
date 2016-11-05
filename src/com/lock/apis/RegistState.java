package com.lock.apis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.util.StaticResource;
/**
 * 注册状态查询
 * @author GarryChung
 * 开始录入指纹后，查询指纹录入情况
 */
@WebServlet("/apis/registstate")
public class RegistState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistState() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().print("{\"msg\":\""+StaticResource.addResult+"\"}");
	}

}
