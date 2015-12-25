package com.inspur.spring.util;

import java.util.UUID;

public class IdWorker {
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
