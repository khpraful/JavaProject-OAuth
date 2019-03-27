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
import com.oauth.utility.CustomRequest;
import com.oauth.utility.TokenManager;

@WebFilter("/TokenFilter")
public class TokenFilter implements Filter {

	public TokenFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String token = req.getParameter("token");
		int id = Integer.parseInt(req.getParameter("id"));

		if (token == null) {

			token = TokenManager.getToken(id);
		}

		CustomRequest cusReq = new CustomRequest(req);
		cusReq.addHeader("token", token);
		System.out.println("Token sent: " + token);

		chain.doFilter(cusReq, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
