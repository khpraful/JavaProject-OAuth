package com.oauth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.oauth.services.LoginServices;

@WebFilter("/RequestFilter")
public class RequestFilter implements Filter {

	public RequestFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String token = req.getParameter("token");

		if (token == null) {
			System.out.println("Token not issued yet");
			token = LoginServices.authenticateUser(req);
			System.out.println("Generated Token: " + token);
			if (token != null) {
				CustomRequest cusReq = new CustomRequest(req);
				cusReq.addHeader("token", token);
				chain.doFilter(cusReq, response);
			} else {
				System.out.println("Invalid user");
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
