package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//表示这是一个bean对象，由spring管理
@RequestMapping("/")
public class HelloController {
	/**
	 * @ReauestMapping注解用于定义请求映射
	 * @return ModelAndView为spring mvc中提供的一个
	 * 值对象（Value Object）：用户封装控制层数据和视图信息
	 */
	@RequestMapping("doSayHello")//map.put(url,Method)
	public ModelAndView doSayHello(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg", "Hello");
		mv.setViewName("hello");
		return mv;//返回值会传递给前端控制器DispatcherServlet对象
		//DispatcherServlet对象会将view交给视图解析器ViewResover
		//对象进行解析
	}
	
}
