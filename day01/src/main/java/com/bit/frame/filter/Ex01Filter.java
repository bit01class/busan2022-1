package com.bit.frame.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "key",value = "val"))
public class Ex01Filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Ex01Filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before Ex01Filter doFilter");
		long before=System.currentTimeMillis();
		chain.doFilter(request, response);
		long after=System.currentTimeMillis();
		System.out.println("after Ex01Filter doFilter");
	}

	@Override
	public void destroy() {
		System.out.println("Ex01Filter destroy");
	}

}
