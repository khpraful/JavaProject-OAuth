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
import javax.servlet.http.HttpServletResponse;

import com.oauth.configuration.SecurityConfig;
import com.oauth.utility.TokenManager;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter("/RequestFilter")
public class RequestFilter implements Filter {

	FilterConfig fConfig;

	/**
	 * Default constructor.
	 */
	public RequestFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String token = fConfig.getInitParameter("token");

		System.out.println("Initial token: " + token);

		if (token == null) {

			int id = SecurityConfig.authenticateUser("admin", "admin");

			if (id != 0) {
				token = TokenManager.getToken(id);
			} else {
				System.out.println("Invalid user");
			}
		}
		CustomRequest cusReq = new CustomRequest(req);
		cusReq.addHeader("token", token);
		System.out.println("Token sent: " + token);

		chain.doFilter(cusReq, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig = fConfig;

	}

}
