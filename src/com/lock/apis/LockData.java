package com.lock.apis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.util.StaticResource;
/**
 * 门锁状态查询
 * @author GarryChung
 *
 */
@WebServlet("/apis/lockdata")
public class LockData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LockData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().print("lock:"+StaticResource.connect+"<br/>"+"<br/>");
		response.getWriter().print("bettery:"+StaticResource.battery+"<br/>"+"<br/>");
		response.getWriter().print("time:"+StaticResource.time);
	}

}
