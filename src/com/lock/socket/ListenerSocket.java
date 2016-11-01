package com.lock.socket;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lock.service.SocketOpenRecordService;
import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;

public class ListenerSocket implements Runnable{
	Socket socket = null;
	SocketUtil socketUtil = null;
	boolean state = true;
	
	public ListenerSocket(Socket socket) {
		this.socket = socket;
		socketUtil = new SocketUtil(socket,StaticResource.outputStream,StaticResource.inputStream);
	}
	
	@Override
	public void run() {
		while(state){
			try {
				System.out.println("准备接收");
				//接收数据
				String json =  socketUtil.receiveData();
				//使用gson解析
				Gson gson = new Gson();
				Map<String, String> map = gson.fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
				//判断json的act字段内容，采取操作
				jsonOperate(map);
			} catch (IOException e) {
				StaticResource.socket=null;
				state = false;
				System.out.println("Socket已经删除");
			}
		}
	}
	
	private void jsonOperate(Map<String, String> map){
		if (map.get("act").equals("openRecord")) {
			//开门记录添加
			SocketOpenRecordService openRecordService = new SocketOpenRecordService(map.get("fin"));
			openRecordService.savaOpenRecord();
		} else {

		}
	}
}
