package com.bit.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class Step03 implements Servlet {
	ServletConfig config;

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

}
