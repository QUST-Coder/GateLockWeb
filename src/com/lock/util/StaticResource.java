package com.lock.util;
/**
 * 静态资源
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.lock.domain.*;

public class StaticResource {
	public static Socket socket = null;
	public static OutputStream outputStream = null;
	public static InputStream inputStream = null;
	
	//门锁运行状态
	public static String time = "";
	public static String battery = "";
	
	//添加指纹返回的状态码
	public static String addResult = "";
	
	//指纹数据
	public static FingerData fingerData = null;
	
	//申请开始注册指纹时返回的状态
	public static String lockState= "";
	
}
