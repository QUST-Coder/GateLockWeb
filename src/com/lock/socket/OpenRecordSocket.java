package com.lock.socket;

import java.io.IOException;
import java.net.Socket;

import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;

public class OpenRecordSocket implements Runnable{
	Socket socket = null;
	SocketUtil socketUtil = null;
	boolean state = true;

	
	public OpenRecordSocket(Socket socket) {
		this.socket = socket;
		socketUtil = new SocketUtil(socket);
	}
	
	@Override
	public void run() {
		while(state){
			try {
				System.out.println("准备接受");
				String text =  socketUtil.receiveData();
				if (text == null) {
					
				}
				System.out.println(text);
			} catch (IOException e) {
				StaticResource.socketList.remove(socket);
				state = false;
				System.out.println("Socket已经删除");
			}
		}
	}
}
