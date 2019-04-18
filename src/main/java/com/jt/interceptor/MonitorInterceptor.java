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
 * 通过如下拦截器实现12306中简易的访问控制
 * 需求：按时间段实现访问控制
 * @author Administrator
 *
 */
public class MonitorInterceptor extends HandlerInterceptorAdapter{
	/**
	 * 此方法中实现按时间段的访问和拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在此位置获取方法上的注解
		//1.方法上没有TimeMonitor注解则直接放行
		//2.方法上有TimeMonitor注解则执行如下访问控制
		HandlerMethod hm=(HandlerMethod) handler;
		Method targetMethod=hm.getMethod();
		boolean flag=
		targetMethod.isAnnotationPresent(TimeMonitor.class);
		if(!flag)return true;
		
		//1.获取当前时间
		long time=System.currentTimeMillis();
		//2.验证当前时间是否在访问时间段之间
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 6);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.MILLISECOND,0);
		long startTime=c.getTimeInMillis();
		System.out.println(startTime);
		System.out.println(time);
		if(time<startTime){
			System.out.println("六点之前禁止使用此功能");
			return false;
		}
		c.set(Calendar.HOUR_OF_DAY, 23);
		long endTime=c.getTimeInMillis();
		if(time>endTime){
			System.err.println("23点之后禁止使用此功能");
			return false;
		}
		return true;
		
	}
}
