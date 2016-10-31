package com.lock.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.service.OpenDoorService;
import com.lock.service.SocketOpenRecordService;

@WebServlet("/OpenDoorServlet")
public class OpenDoorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OpenDoorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String passWord = request.getParameter("passWord");
		
		OpenDoorService openDoorService = new OpenDoorService(studentId, passWord);
		try {
			String openResult = openDoorService.open();
			request.setAttribute("openResult", openResult);
			response.sendRedirect(request.getContextPath() + "/open.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}