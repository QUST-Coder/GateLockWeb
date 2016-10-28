package com.lock.util;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticResource {
	public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());

}
