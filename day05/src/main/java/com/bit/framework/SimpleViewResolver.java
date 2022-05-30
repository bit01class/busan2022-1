package com.bit.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleViewResolver implements BitViewResolver {
	String prefix;
	String suffix;

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void viewResolver(String viewName,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(viewName.startsWith("redirect:")) {
			resp.sendRedirect(viewName.substring("redirect:".length()));
			return;
		}
		
		req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);
	}
}













