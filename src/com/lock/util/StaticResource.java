package com.lock.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.lock.domain.*;



public class StaticResource {
	public static Socket socket = null;
	public static OutputStream outputStream = null;
	public static InputStream inputStream = null;
	public static String time = null;
	public static String battery = null;
	public static String addResult = null;
	public static FingerData fingerData = null;
	
}
