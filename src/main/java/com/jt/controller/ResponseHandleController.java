package com.jt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resp/")
public class ResponseHandleController {
	@RequestMapping("doResponseUI")
	public String doResponseUI(HttpServletRequest request){
		
		return "response";//forward����ת��
	}
	@RequestMapping("doRedirectUI")
	public String doRedirectUI(HttpServletRequest request,HttpSession session){
		request.setAttribute("msg", "hello");
		//�ض��򷵻�ֵ��ǰ׺����Ϊ��redirect
		session.setAttribute("user", "session");
		return "redirect:doResponseUI.do";
	}
}
