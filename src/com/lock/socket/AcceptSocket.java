package com.lock.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.lock.util.StaticResource;
/**
 * 侦听类
 * 不断侦听Socket连接，将连接的Socket记录，并开启线程接受传来的数据
 * @author plzwb
 */
public class AcceptSocket implements Runnable{
	ServerSocket serverSocket = null;
	
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(2333);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("2333端口被占用");
		}
		
		while (true) {
			try {
				//获取socket
				Socket socket = serverSocket.accept();
				StaticResource.socket = socket;
				//设置输出输入流
				StaticResource.outputStream = socket.getOutputStream();
				StaticResource.inputStream = socket.getInputStream();
				//启动新线程监听
				new Thread(new ListenerSocket(socket)).start();
				StaticResource.connect = "已连接";
				System.out.println("门锁已连接");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("accept异常");
			}
		}
	}
}
