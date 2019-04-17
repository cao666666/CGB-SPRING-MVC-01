package com.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.controller.SysLog;


public class TestJackson01 {
	@Test
	public void testMapToString() throws Exception{
		Map<String, Object> map=new HashMap<>();
		map.put("id","hello");
		map.put("name", "hello");
		//��map����ת��Ϊjson�ַ���
		ObjectMapper om=new ObjectMapper();
		String s=om.writeValueAsString(map);
		System.out.println(s);
		
		// ��json��ת��Ϊjava����
		Map<?, ?> map2=om.readValue(s, Map.class);
		System.out.println(map2);
	}
	@Test
	public void testLogToString()throws Exception{
		SysLog log=new SysLog();
		log.setId(100);
		log.setMethod("update");
		log.setIp("192.168.1.1");
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(log);
		System.out.println(jsonStr);
		
		SysLog log2=om.readValue(jsonStr, SysLog.class);
		System.out.println(log2.getIp());
		
	}
}
