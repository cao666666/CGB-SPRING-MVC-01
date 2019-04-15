package com.jt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/reg/")
@Controller
public class RequestHandleController {
	//===========请求资源路径映射========
	//多个路径映射同一个资源
	@RequestMapping(value={"doRequestURL01","doReqURL01"})
	@ResponseBody
	public String doRequestURL01(){
		return "doRequestURL01";
	}
	
	//rest风格的url编写，其中{n}可以看成是一个变量
	@RequestMapping("doReqRest/{n}")
	@ResponseBody
	public String doRequestURL02(@PathVariable("n") Integer n1){
		return "doRequestURL02"+n1;
		//@PathVariable 修饰是参数用于获取url中的参数值
		//@PathVariable修饰的参数用于获取url中的参数值
	}
	@RequestMapping(value="doRequestMethod01",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String doRequestMethod01(){
		return "doRequestMethod01";
	}
	//此方法只能处理Get请求映射
	@GetMapping("doRequestMethod02")
	@ResponseBody
	public String doRequestMethod02(){
		return "doRequestMethod02";
	}
	//此方法只能处理post请求的映射
	@PostMapping("doRequestMethod02")
	@ResponseBody
	public String doRequestMethod03(){
		return "doRequestMethod02";
	}
	
	//======请求参数映射======
	//使用servlet原生API获取请求参数数据
	@GetMapping("doRequestParam01")
	@ResponseBody
	public String doRequestParam01(HttpServletRequest request){
		String page=request.getParameter("page");
		System.out.println(page);
		if(page!=null&&!"".equals(page)){
			Integer pageCurrent=Integer.parseInt(page);
			return "obtain's value is:"+ pageCurrent; 
		}
		return "obtain's value is null";
	}//HttpServletRequest有tomcat创建，由spring mvc进行装配
	
	@GetMapping("doRequestParam02")
	@ResponseBody
	public String doRequestParam02(Integer page){
		return "obtain's value is"+page;
	}//integer 参数对象由spring mvc创建,由mvc将请求参数值注入给方法参数
}
