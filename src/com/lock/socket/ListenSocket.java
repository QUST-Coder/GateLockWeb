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
public class ListenSocket implements Runnable{
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
				Socket socket = serverSocket.accept();
				StaticResource.socket = socket;
				StaticResource.outputStream = socket.getOutputStream();
				StaticResource.inputStream = socket.getInputStream();
				new Thread(new OpenRecordSocket(socket)).start();
				System.out.println("Socket已连接");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("accept异常");
			}
		}
	}
}
