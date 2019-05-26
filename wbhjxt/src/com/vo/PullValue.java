package com.vo;


import javax.servlet.http.HttpSession;

public class PullValue {
	
	private String uuid; 
	private HttpSession session;
	
	public PullValue(String uuid, HttpSession session) {
		super();
		this.uuid = uuid;
		this.session = session;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "PullValue [uuid=" + uuid + ", session=" + session + "]";
	}
	
}
