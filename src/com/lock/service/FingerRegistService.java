package com.lock.service;

import java.io.IOException;

import com.lock.util.SocketUtil;
import com.lock.util.StaticResource;
/**
 * 发送第一次添加指纹的Socket
 * @author GarryChung
 *
 */
public class FingerRegistService {
	SocketUtil socketUtil = new SocketUtil(StaticResource.socket, StaticResource.outputStream, StaticResource.inputStream);
	
	public boolean regist() {
		String data = "{\"act\":\"addFinger\"}";
		try {
			socketUtil.sendData(data);
		} catch (IOException e) {
			StaticResource.socket = null;
			StaticResource.outputStream = null;
			StaticResource.inputStream = null;
			System.out.println("Socket已经删除");
		}
		if (StaticResource.lockState != null) {
			if (StaticResource.lockState.equals("1")) {
				return true;
			}
		}
		return false;
	}
}
