package com.lock.apis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lock.util.StaticResource;

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
		response.getWriter().print("{\"msg\":\""+StaticResource.addResult+"\"}");
	}

}
