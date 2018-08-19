package com.demo.config;

import java.io.IOException;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		System.out.println("Filtering on...........................................................");
		HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("AccessControlAllowOrigin", "*");
        response.setHeader("AccessControlAllowCredentials", "true");
		response.setHeader("AccessControlAllowMethods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("AccessControlMaxAge", "3600");
        response.setHeader("AccessControlAllowHeaders", "XRequestedWith, ContentType, Authorization, Origin, Accept, AccessControlRequestMethod, AccessControlRequestHeaders");

		chain.doFilter(req, res);

	}


	public void init(FilterConfig filterConfig) {}


	public void destroy() {}



}
