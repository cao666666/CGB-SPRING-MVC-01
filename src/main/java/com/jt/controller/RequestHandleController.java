package com.jt.controller;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/reg/")
@Controller
public class RequestHandleController {
	//===========������Դ·��ӳ��========
	//���·��ӳ��ͬһ����Դ
	@RequestMapping(value={"doRequestURL01","doReqURL01"})
	@ResponseBody
	public String doRequestURL01(){
		return "doRequestURL01";
	}
	
	//rest����url��д������{n}���Կ�����һ������
	@RequestMapping("doReqRest/{n}")
	@ResponseBody
	public String doRequestURL02(@PathVariable("n") Integer n1){
		return "doRequestURL02"+n1;
		//@PathVariable �����ǲ������ڻ�ȡurl�еĲ���ֵ
		//@PathVariable���εĲ������ڻ�ȡurl�еĲ���ֵ
	}
	@RequestMapping(value="doRequestMethod01",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String doRequestMethod01(){
		return "doRequestMethod01";
	}
	//�˷���ֻ�ܴ���Get����ӳ��
	@GetMapping("doRequestMethod02")
	@ResponseBody
	public String doRequestMethod02(){
		return "doRequestMethod02";
	}
	//�˷���ֻ�ܴ���post�����ӳ��
	@PostMapping("doRequestMethod02")
	@ResponseBody
	public String doRequestMethod03(){
		return "doRequestMethod02";
	}
	
	//======�������ӳ��======
	//ʹ��servletԭ��API��ȡ�����������
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
	}//HttpServletRequest��tomcat��������spring mvc����װ��
	
	@GetMapping("doRequestParam02")
	@ResponseBody
	public String doRequestParam02(@RequestParam("page") Integer pageCurrent){
		return "obtain's value is"+pageCurrent;
	}//integer ����������spring mvc����,��mvc���������ֵע�����������

	@GetMapping("doRequestParam03")
	@ResponseBody
	public String doRequestParam03(@DateTimeFormat(pattern="yyyy-MM-dd")Date startDate){
		return "obtain's value is:"+startDate;
	}
	@GetMapping("doRequestParam04")
	@ResponseBody
	public String doRequestParam04(Integer[] ids,HttpServletRequest request){
		String is=request.getParameter("ids");
		System.out.println(is);
		return "obtain's value is"+Arrays.toString(ids);
	}
	
	
	@GetMapping("doRequestParam05")
	@ResponseBody
	public String doRequestParam05(Integer... ids){
		return "obtain's value is:"+Arrays.toString(ids);
	}
	
	@GetMapping("doRequestParam07")
	@ResponseBody
	public String doRequestParam06(SysLog entity){
		return "obtain's value is"+entity.getUsername();
	}
	
	@RequestMapping(value="header",method=RequestMethod.GET)
	@ResponseBody
	public String withHeader(@RequestHeader("Accept-Encoding") String acceptencoding){
		return "Obtained 'Accept header':"+acceptencoding;
	}
	
	@GetMapping("doRequestParam06")
	@ResponseBody
	public String withCooke(@CookieValue String JSESSIONID){
		return "Obtained COOKIE value:"+JSESSIONID;
	}
	
}
