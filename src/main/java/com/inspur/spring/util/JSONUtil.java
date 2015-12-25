package com.inspur.spring.util;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class JSONUtil {

	public static String Object2JSON(Object object) {
		return JSON.toJSONString(object);
	}

	public static <T> T JSON2Object(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}

	public static <T> List<T> JSON2Array(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}
}
