package com.lock.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketUtil {
	Socket socket = null;
	OutputStream outputStream = null;
	InputStream inputStream = null;

	public SocketUtil(Socket socket,OutputStream outputStream,InputStream inputStream) {
		super();
		this.socket = socket;
		this.outputStream = outputStream;
		this.inputStream = inputStream;
	}
	
	//发送数据
	public void sendData(String data) throws IOException {
		outputStream.write(data.getBytes());
	}
	
	//接收数据
	public String receiveData() throws IOException {
		byte[] buf = new byte[1024];
		int len = inputStream.read(buf);
		if (len < 0) {
			return null;
		}
		String text = new String(buf, 0, len);
		return text;
	}
}
