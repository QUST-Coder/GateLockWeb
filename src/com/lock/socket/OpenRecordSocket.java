package com.lock.socket;

import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;
import com.lock.service.SocketOpenRecordService;
import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;

public class OpenRecordSocket implements Runnable{
	Socket socket = null;
	SocketUtil socketUtil = null;
	boolean state = true;

	
	public OpenRecordSocket(Socket socket) {
		this.socket = socket;
		socketUtil = new SocketUtil(socket,StaticResource.outputStream,StaticResource.inputStream);
	}
	
	@Override
	public void run() {
		while(state){
			try {
				System.out.println("准备接受");
				String jsonString =  socketUtil.receiveData();
				SocketOpenRecordService openRecordService = new SocketOpenRecordService(jsonString);
			} catch (IOException e) {
				StaticResource.socket=null;
				state = false;
				System.out.println("Socket已经删除");
			}
		}
	}
}
