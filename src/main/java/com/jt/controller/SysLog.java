package com.jt.controller;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4138810560255477757L;
	/**
	 * ��־id
	 */
	private Integer id;
	/**
	 * �û���
	 */
	private String username;
	/**
	 * �û�����
	 */
	private String operation;
	/**
	 * ���󷽷�
	 */
	private String method;
	/**
	 * �������
	 */
	private String params;
	/**
	 * ִ��ʱ��
	 */
	private Long time;
	/**
	 * IP��ַ
	 */
	private String ip;
	/**
	 * ����ʱ��
	 */
	private Date createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
	
}