package com.lock.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketUtil {
	Socket socket = null;

	public SocketUtil(Socket socket) {
		super();
		this.socket = socket;
	}
	
	//发送数据
	public void sendData(String data) throws IOException {
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(data.getBytes());
	}
	
	//接收数据
	public String receiveData() throws IOException {
		InputStream inputStream = socket.getInputStream();
		byte[] buf = new byte[1024];
		int len = inputStream.read(buf);
		if (len < 0) {
			return null;
		}
		String text = new String(buf, 0, len);
		return text;
	}
}
