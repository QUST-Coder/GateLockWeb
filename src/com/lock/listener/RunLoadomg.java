package com.lock.listener;


import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lock.socket.ListenSocket;
/**
 * 侦听器程序启动时运行
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
		new Thread(new ListenSocket()).start();
	}

}
