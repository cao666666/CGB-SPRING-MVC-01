package com.jt.interceptor;

import java.lang.reflect.Method;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jt.annotation.TimeMonitor;


/**
 * ͨ������������ʵ��12306�м��׵ķ��ʿ���
 * ���󣺰�ʱ���ʵ�ַ��ʿ���
 * @author Administrator
 *
 */
public class MonitorInterceptor extends HandlerInterceptorAdapter{
	/**
	 * �˷�����ʵ�ְ�ʱ��εķ��ʺ�����
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//�ڴ�λ�û�ȡ�����ϵ�ע��
		//1.������û��TimeMonitorע����ֱ�ӷ���
		//2.��������TimeMonitorע����ִ�����·��ʿ���
		HandlerMethod hm=(HandlerMethod) handler;
		Method targetMethod=hm.getMethod();
		boolean flag=
		targetMethod.isAnnotationPresent(TimeMonitor.class);
		if(!flag)return true;//û��ע�⣬ֱ�ӷ���
		
		//1.��ȡ��ǰʱ��
		long time=System.currentTimeMillis();
		//2.��֤��ǰʱ���Ƿ��ڷ���ʱ���֮��
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 6);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);
		long startTime=c.getTimeInMillis();
		System.out.println(startTime);
		System.out.println(time);
		if(time<startTime){
			System.out.println("����֮ǰ��ֹʹ�ô˹���");
			return false;
		}
		c.set(Calendar.HOUR_OF_DAY, 23);
		long endTime=c.getTimeInMillis();
		if(time>endTime){
			System.err.println("23��֮���ֹʹ�ô˹���");
			return false;
		}
		return true;
		
	}
}
