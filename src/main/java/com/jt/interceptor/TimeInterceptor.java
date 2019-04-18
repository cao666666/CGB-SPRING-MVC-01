package com.jt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * �Զ�������������
 * @author Administrator
 *
 */
public class TimeInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;//true��ʾ���У�false��ʾ����,����ִ�к�������������Ʋ㷽��
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long endTime=System.currentTimeMillis();
		System.out.println("afterCompletion");
		long startTime=(Long) request.getAttribute("startTime");
		System.out.println(startTime);
		System.out.println(endTime-startTime);
		//������:Ҫ������ĸ�������ĸ���������ʱ��
		System.out.println(handler.getClass().getName());
		HandlerMethod hMethod=(HandlerMethod) handler;
		String beanName=hMethod.getBeanType().getName();
		String methodName=hMethod.getMethod().getName();
		System.out.println(beanName+"."+methodName+"��ʱ��:"+(endTime-startTime));
		
		
	}

}
