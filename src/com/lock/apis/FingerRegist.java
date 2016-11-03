package com.lock.apis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.service.FingerRegistService;
/**
 * 指纹注册API
 * @author GarryChung
 * 请求门锁开始检测指纹
 */
@WebServlet("/apis/fingerregist")
public class FingerRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FingerRegist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FingerRegistService fingerRegistService = new FingerRegistService();
		boolean result = fingerRegistService.regist();
		if (result) {
			response.getWriter().print("{\"msg\":\"success\"}");
		}else if (!result) {
			response.getWriter().print("{\"msg\":\"fail\"}");
		}
	}
}
