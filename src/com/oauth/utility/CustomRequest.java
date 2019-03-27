package com.oauth.utility;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomRequest extends HttpServletRequestWrapper {

	private Map<String, String> headerMap = null;

	public CustomRequest(HttpServletRequest request) {
		super(request);
		this.headerMap = new HashMap<String, String>();

	}

	public void addHeader(String key, String value) {
		headerMap.put(key, value);

	}

	public  String getParameter(String key) {
		return headerMap.get(key);

	}

}
