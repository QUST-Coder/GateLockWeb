package com.lock.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lock.socket.AcceptSocket;
/**
 * Socket侦听
 * @author plzwb
 *
 */
@WebListener
public class RunLoadomg implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//启动多线程侦听客户端的Socket连接
		new Thread(new AcceptSocket()).start();
	}

}
