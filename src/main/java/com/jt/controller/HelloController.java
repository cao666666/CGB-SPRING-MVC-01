package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//��ʾ����һ��bean������spring����
@RequestMapping("/")
public class HelloController {
	/**
	 * @ReauestMappingע�����ڶ�������ӳ��
	 * @return ModelAndViewΪspring mvc���ṩ��һ��
	 * ֵ����Value Object�����û���װ���Ʋ����ݺ���ͼ��Ϣ
	 */
	@RequestMapping("doSayHello")//map.put(url,Method)
	public ModelAndView doSayHello(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg", "Hello");
		mv.setViewName("hello");
		return mv;//����ֵ�ᴫ�ݸ�ǰ�˿�����DispatcherServlet����
		//DispatcherServlet����Ὣview������ͼ������ViewResover
		//������н���
	}
	
}
