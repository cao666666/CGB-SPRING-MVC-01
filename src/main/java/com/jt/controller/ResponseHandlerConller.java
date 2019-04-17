package com.jt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resp/")
public class ResponseHandlerConller {
	@RequestMapping("doMapToJsonStr")
	@ResponseBody
	public Map<String, Object> doMapToJsonStr(){
		Map<String, Object> map=new HashMap<>();
		map.put("id", 100);
		map.put("name", "hello");
		return map;
	}
}
