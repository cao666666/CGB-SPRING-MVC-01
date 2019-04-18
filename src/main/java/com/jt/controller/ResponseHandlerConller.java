package com.jt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.annotation.TimeMonitor;

@Controller
@RequestMapping("/resp/")
public class ResponseHandlerConller {
	/**
	 * �����ǵķ�������@TimeMonitorע�⣬��Ҫ�Դ˷���
	 * �ķ���ʱ���������
	 * @return
	 */
	@TimeMonitor
	@RequestMapping("/list/doMapToJsonStr")
	@ResponseBody
	public List<Map<String, Object>> doListToJsonStr(){
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		map.put("id", 100);
		map.put("name", "hello");
		list.add(map);
		return list;
	}
	@RequestMapping("/list/doMapToJsonStr2")
	@ResponseBody
	public List<Map<String, Object>> doListToJsonStr2(){
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		map.put("id", 100);
		map.put("name", "hello2");
		list.add(map);
		return list;
	}
}
