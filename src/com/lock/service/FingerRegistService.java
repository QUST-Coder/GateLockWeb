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
		
		Integer a = 1;
		for (int i = 0; i < 99999; i++) {
			for (int j = 0; i < 99999; i++) {
				for (int k = 0; i < 99999; i++) {
					for (int l = 0; i < 99999; i++) {
						for (int m = 0; i < 99999; i++) {
							for (int n = 0; i < 99999; i++) {
								a++;
							}

						}

					}

				}

			}

		}
		
		if (StaticResource.lockState.equals("successful")) {
			return true;
		}
		return false;
	}
}
