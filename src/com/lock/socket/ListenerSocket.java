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
 * 解析
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
				StaticResource.socket=null;
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
			StaticResource.addResult = "successful";
		}else if (map.get("act").equals("fingerResult")) {
			if(map.get("msg").equals("521")){
				//注册成功
				StaticResource.fingerData = new FingerData("",map.get("fin1"),map.get("fin2"),map.get("fin3"),map.get("fin4"),map.get("fin5"));
				StaticResource.addResult = msg(map.get("msg"));
			}else {
				//注册过程未完成，返回相应信息
				StaticResource.addResult = msg(map.get("msg"));
			}
		}
	}
	/**
	 * 识别响应码
	 * @param msg
	 * @return 响应码对应的信息
	 */
	private String msg(String msg) {
		int m = Integer.parseInt(msg);
		String res = null;
		switch (m) {
		case 111:
			res = "第一个手指，第一次识别成功!请再次识别同一手指！";
			break;
		
		case 110:
			res = "第一个手指，第一次识别失败！请再次识别同一手指！";
			break;
		
		case 121:
			res = "第一个手指，第二次识别成功！请按压下个手指！";
			break;
		
		case 120:
			res = "第一个手指，第二次识别失败！请再次识别同一手指！";
			break;
		
		case 211:
			res = "第二个手指，第一次识别成功！请再次识别同一手指！";
			break;
		
		case 210:
			res = "第二个手指，第一次识别失败！请再次识别同一手指！";
			break;
		
		case 221:
			res = "第二个手指，第二次识别成功!请按压下个手指！";
			break;
		
		case 220:
			res = "第二个手指，第二次识别成功！请再次识别同一手指！";
			break;
		
		case 311:
			res = "第三个手指，第一次识别成功！请再次识别同一手指！";
			break;
		
		case 310:
			res = "第三个手指，第一次识别成功!请再次识别同一手指！";
			break;
		
		case 321:
			res = "第三个手指，第二次识别成功！请按压下个手指！";
			break;

		case 320:
			res = "第三个手指，第二次识别成功！请再次识别同一手指！";
			break;
		
		case 411:
			res = "第四个手指，第一次识别成功！请再次识别同一手指！";
			break;
		
		case 410:
			res = "第四个手指，第一次识别成功！请再次识别同一手指！";
			break;
		
		case 421:
			res = "第四个手指，第二次识别成功！请按压下个手指！";
			break;

		case 420:
			res = "第四个手指，第二次识别成功！请再次识别同一手指！";
			break;
		
		case 511:
			res = "第五个手指，第一次识别成功！请再次识别同一手指！";
			break;
		
		case 510:
			res = "第五个手指，第一次识别成功！请再次识别同一手指！";
			break;
		
		case 521:
			res = "第五个手指，第二次识别成功！您的指纹已经识别完成！";
			break;

		case 520:
			res = "第五个手指，第二次识别成功！请再次识别同一手指！";
			break;			
		}
		return res;
	}
}
