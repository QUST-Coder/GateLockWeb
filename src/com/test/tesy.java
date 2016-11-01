package com.test;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class tesy {

	public static void main(String[] args) {
		String json = "{\"name\":\"仲惟彬\",\"age\":12}";
		Gson gson = new Gson();
		Map<String, String> map = gson.fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
		System.out.println(map.get("name")+"~~~"+map.get("age"));
	}

}
