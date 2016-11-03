package com.lock.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lock.domain.FingerData;
import com.lock.service.SocketOpenRecordService;
import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;
/**
 * Socket数据监听
 * @author GarryChung
 *
 */
public class ListenerSocket implements Runnable{
	Socket socket = null;
	SocketUtil socketUtil = null;
	boolean state = true;
	
	public ListenerSocket(Socket socket) {
		this.socket = socket;
		socketUtil = new SocketUtil(socket,StaticResource.outputStream,StaticResource.inputStream);
	}
	
	/**
	 * 线程不断接收硬件传来的json
	 */
	@Override
	public void run() {
		while(state){
			try {
				System.out.println("准备接收");
				//接收数据
				String json =  socketUtil.receiveData();
				System.out.println(json);
				//使用gson解析
				Gson gson = new Gson();
				Map<String, String> map = gson.fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
				//判断json的act字段内容，采取操作
				jsonOperate(map);
			} catch (IOException e) {
				//重置静态资源
				StaticResource.socket = null;
				StaticResource.outputStream = null;
				StaticResource.inputStream = null;
				StaticResource.connect = "未连接";
				//不再进入接收状态
				state = false;
				System.out.println("Socket已经删除");
			}
		}
	}
	
	/**
	 * 解析json映射的Map
	 * @param map
	 */
	private void jsonOperate(Map<String, String> map){
		if (map.get("act").equals("openRecord")) {
			//开门记录添加
			SocketOpenRecordService openRecordService = new SocketOpenRecordService(map.get("fin"));
			openRecordService.savaOpenRecord();
		}else if(map.get("act").equals("heartBeat")){
			//心跳包检测
			StaticResource.time = map.get("time");
			StaticResource.battery = map.get("Battery");
		}else if (map.get("act").equals("successful")) {
			//注册状态检测
			StaticResource.lockState = "successful";
		}else if (map.get("act").equals("fingerResult")) {
			if(map.get("msg").equals("521")){
				//注册成功,返回信息并将指纹写入静态类
				StaticResource.fingerData = new FingerData("",map.get("fin1"),map.get("fin2"),map.get("fin3"),map.get("fin4"),map.get("fin5"));
				StaticResource.addResult = map.get("msg");
			}else{
				//注册过程未完成，返回相应信息
				StaticResource.addResult = map.get("msg");
			}
		}else {
			System.out.println("未知json");
		}
	}
}
