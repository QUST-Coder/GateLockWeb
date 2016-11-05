package com.lock.apis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.service.IdDetectionService;
/**
 * 用户ID查重
 * @author GarryChung
 *
 */
@WebServlet("/apis/iddetection")
public class IdDetection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdDetection() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String id = (String) request.getParameter("studentId");
		IdDetectionService idDetectionService = new IdDetectionService();
		String result = idDetectionService.select(id);
		if (result.equals(id)) {
			response.getWriter().print("{\"msg\":\"success\"}");
		} else {
			response.getWriter().print("{\"msg\":\"fail\"}");
		}
	}
}
