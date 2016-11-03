package com.lock.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.service.WebOpenDoorService;
import com.lock.util.StaticResource;
/**
 * 开门Servelet
 * @author GarryChung
 *
 */
@WebServlet("/OpenDoorServlet")
public class OpenDoorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OpenDoorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String passWord = request.getParameter("passWord");
		//判断门锁是否连接
		if (StaticResource.connect.equals("未连接")) {
			request.getSession().setAttribute("openResult", "门锁尚未连接请联系管理员！");
			response.sendRedirect(request.getContextPath() + "/open.jsp");
		}else {
			WebOpenDoorService WebOpenDoorService = new WebOpenDoorService(studentId, passWord);
			//发送开门请求，由Service负责验证用户
			String openResult = WebOpenDoorService.open();
			//返回开门结果
			request.getSession().setAttribute("openResult", openResult);
			response.sendRedirect(request.getContextPath() + "/open.jsp");
		}
	}
}
